package edu.odu.cs.cs350.pne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        ArrayList<History> PreviousSemestersData;
        ArrayList<LocalDate> Date;
        PreviousSemestersData = new ArrayList<History>();
        Date = new ArrayList<LocalDate>();
        // DataImport instance = new DataImport();
        if (args[0] == null || args[0].trim().isEmpty()) {
            System.out.println("You need to specify a path!");
            return;
        } else {
            for (String Directory : args)
                try {
                    PreviousSemestersData.add(new Main().GetFileContents(Directory));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        for (History hist : PreviousSemestersData) {
            // System.out.println(hist.getSemester());
            for (int i = 0; i < hist.getSemester().size(); i++) {
                Semester semes = hist.getSemesterByIndex(i);
                System.out.println(semes.getSemesterCode());
                System.out.println(hist.getSnapShotByIndex(i));
                // System.out.println(semes);
                List<Offering> Off = semes.getOfferingList();
                // List<String> CRSELst = semes.getCRSEList();
                for (int j = 0; j < Off.size(); j++) {
                    // System.out.println(CRSELst.get(j));
                    System.out.println("    CRSE: " + Off.get(j).getCRSE() + " SUBJ: " + Off.get(j).getSUBJ()
                            + " ENRL: " + Off.get(j).getEnrollment() + " MaxENRL: " + Off.get(j).getMaxEnrollment()
                            + " CurrENRL: " + Off.get(j).getCurrentEnrollment());
                    for (Section sect : Off.get(j).getSection()) {
                        System.out.println("        CRN: " + sect.getCRN() + " Seats Remaining: "
                                + sect.getSeatsRemaining() + " XList Cap: " + sect.getCrossListCap() + " ENRL:"
                                + sect.getEnrollments() + " XList Group: " + sect.getCrossListGroup() + " Instr: "
                                + sect.getInstructor() + " Link: " + sect.getLink());
                    }
                }
            }
        }

    }

    public History GetFileContents(String FilePath) throws IOException {
        File filesList[];
        ArrayList<LocalDate> SnapshotDates, RegistrationDates;
        // Creating a File object for directory.
        File directoryPath = new File(FilePath);
        LocalDate Date = LocalDate.now();
        History history = new History();
        RegistrationDates = new ArrayList<LocalDate>();
        // List of all files and directories.
        filesList = directoryPath.listFiles();
        System.out.println("List of files and directories in the specified directory:");
        Scanner ScannerContents = null;
        boolean ParsedOne = false;
        boolean DatesTxtExists = false;
        boolean HitLastRegistrationDate = false;
        for (File file : filesList) {
            String Filename = file.getName();
            String DatesTxt = "dates.txt";
            if (Filename.contains(DatesTxt)) {
                DatesTxtExists = true;
                try {
                    Scanner sc = null;
                    sc = new Scanner(file);
                    StringBuffer sb = new StringBuffer();
                    String line;
                    while (sc.hasNextLine()) {
                        line = sc.nextLine();
                        System.out.println(line);
                        String[] DateParts = line.split("-");
                        RegistrationDates
                                .add(LocalDate.of(Integer.parseInt(DateParts[0]), Integer.parseInt(DateParts[1]),
                                        Integer.parseInt(DateParts[2])));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (DatesTxtExists == true) {
            int NumSnapshots = 0;
            for (File file : filesList) {
                String[] FilenameParts = FilenameUtils.removeExtension(file.getName()).split("-");
                if (FilenameParts.length == 3) {
                    Date = LocalDate.of(Integer.parseInt(FilenameParts[0]), Integer.parseInt(FilenameParts[1]),
                            Integer.parseInt(FilenameParts[2]));
                    if (Date.isAfter(RegistrationDates.get(0))) {
                        NumSnapshots++;
                    }
                    if (HitLastRegistrationDate == true) {
                        break;
                    }
                    if (Date.isEqual(RegistrationDates.get(1))) {
                        HitLastRegistrationDate = true;
                    }
                }
            }
            if (NumSnapshots < 2) {
                throw new IOException("Insufficient snapshots in " + directoryPath.getName());
            }
            for (File file : filesList) {
                // System.out.println("File name: " + file.getName());
                // Get date of snapshot from filename.
                String Filename = FilenameUtils.removeExtension(file.getName());
                String[] FilenameParts = Filename.split("-");
                // Only perform the filtering action if the file is a snapshot file.
                // Kinda fragile way to do it as it will break if the file naming convention is
                // changed, but it works.
                if (FilenameParts.length == 3) {
                    // Create semester for the snapshot file.
                    Semester semester = new Semester();
                    // System.out.println("Parent : " + file.getParentFile().getName());
                    // Set the semester code by using the name of the parent directory of the file
                    semester.SetSemesterCode(file.getParentFile().getName());
                    Date = LocalDate.of(Integer.parseInt(FilenameParts[0]), Integer.parseInt(FilenameParts[1]),
                            Integer.parseInt(FilenameParts[2]));
                    System.out.println("Date : " + Date);
                    if (Date.isEqual(RegistrationDates.get(1))) {
                        HitLastRegistrationDate = true;
                    }
                    if (Date.isAfter(RegistrationDates.get(0))) {
                        // SnapshotDates.add(Date);
                        // Reads the CSV file.
                        Reader CSVFile = Files.newBufferedReader(Paths.get(file.getPath()));
                        // Parses the CSV file into something that can be worked with.
                        CSVParser parser = CSVParser.parse(CSVFile, CSVFormat.RFC4180);
                        List<CSVRecord> csvRecords = parser.getRecords();
                        // Offering class needs columns C, D, W, X: 2, 3, 22, 23
                        // Section class needs columns A, B, G, H, I, J, U: 0, 1, 6, 7, 8, 9, 20
                        // Needs to sort all of the items into sections, offerings and semesters.
                        String LastCRSE = "";
                        String LastXListGroup = "";
                        String LastSUBJ = "";
                        // Create blank offering.
                        Offering offering = new Offering();
                        // Create blank section.
                        Section section = new Section();
                        boolean OfferingInSemester = false;
                        for (int i = 1; i < csvRecords.size(); i++) {
                            CSVRecord csvRecord = csvRecords.get(i);
                            boolean OfferingMatch = false;
                            // Grab relavent items from the CSV.
                            int Seats = Integer.parseInt(csvRecord.get(0));
                            int CRN = Integer.parseInt(csvRecord.get(1));
                            String SUBJ = csvRecord.get(2);
                            String CRSE = csvRecord.get(3);
                            int XListCap = Integer.parseInt(csvRecord.get(6));
                            int ENR = Integer.parseInt(csvRecord.get(7));
                            String Link = csvRecord.get(8);
                            String XListGroup = csvRecord.get(9);
                            String Instructor = csvRecord.get(20);
                            String OverallCapStr = csvRecord.get(22);
                            int OverallCap;
                            if (!OverallCapStr.equals("")) {
                                OverallCap = Integer.parseInt(OverallCapStr);
                            } else {
                                OverallCap = XListCap;
                            }
                            int OverallEnr = Integer.parseInt(csvRecord.get(23));
                            // Create new offering if the course is not equal to the previous course.
                            if (!CRSE.equals(LastCRSE) || !XListGroup.equals(LastXListGroup) || XListGroup.equals("")) {
                                if (OfferingMatch == false) {
                                    // Add the offering to the semester when creating the new offering if the
                                    // section is not empty
                                    if (offering.getSection().size() > 0 && !OfferingInSemester) {
                                        semester.addOffering(offering);
                                        semester.addCRSE(CRSE);
                                    }
                                    // Create a new offering if the Last course is not the same as the current one.
                                    offering = new Offering();
                                    offering.setCRSE(CRSE);
                                    offering.setSUBJ(SUBJ);
                                    offering.setEnrollment(OverallEnr);
                                    offering.setMaxEnrollment(OverallCap);
                                    offering.setCurrentEnrollment(OverallEnr);
                                    OfferingInSemester = false;
                                }
                                // Check to see if the course and link are in the previously created offerings.
                                if (!XListGroup.equals("")) {
                                    for (Offering Off : semester.getOfferingList()) {

                                        if ((Off.getCRSE().equals(CRSE)
                                                && Off.accessSection(0).getCrossListGroup().equals(XListGroup))
                                                && Off.getSUBJ().equals(SUBJ)) {
                                            OfferingMatch = true;
                                            OfferingInSemester = true;
                                            offering = Off;
                                        }
                                    }
                                }
                            }
                            // Add relavent items to the section
                            if (Link.length() == 2) {
                                if (Link.charAt(1) == '1') {
                                    section = new Section(CRN, Seats, XListCap, ENR, XListGroup, Instructor, Link);
                                    offering.addSection(section);
                                }
                            } else {
                                section = new Section(CRN, Seats, XListCap, ENR, XListGroup, Instructor, Link);
                                offering.addSection(section);
                            }
                            // Set the last course so that sections can be properly added to the offering
                            LastCRSE = CRSE;
                            // Sets the last cross list group so that the linked courses are put in the same
                            // offering
                            LastXListGroup = XListGroup;
                            LastSUBJ = SUBJ;
                        }
                        if (offering.getSection().size() > 0 && !OfferingInSemester) {
                            semester.addOffering(offering);
                            semester.addCRSE(offering.getCRSE());
                        }
                        history.addSemester(semester);
                        history.addSnapShotDate(Date);
                    }

                    System.out.println("File path: " + file.getAbsolutePath());
                    System.out.println(" ");
                    // history.setSnapShotDate(SnapshotDates);
                }
            }
        } else if (DatesTxtExists == false) {
            throw new IOException("Missing dates.txt in " + directoryPath.getName());
        }
        return history;
    }
}