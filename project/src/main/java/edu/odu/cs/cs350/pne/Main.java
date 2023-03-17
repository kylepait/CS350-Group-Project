package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
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
                PreviousSemestersData.add(new Main().GetFileNames(Directory));
        }
        /*
         * for (History Snapshot : Snapshots) {
         * Date = Snapshot.getSnapShotDate();
         * for (LocalDate SnapDate : Date)
         * System.out.println("Snapshot Date: " + SnapDate);
         * }
         */
    }

    private History GetFileNames(String FilePath) throws IOException {
        File filesList[];
        ArrayList<LocalDate> SnapshotDates;
        // Creating a File object for directory.
        File directoryPath = new File(FilePath);
        LocalDate Date = LocalDate.now();
        History history = new History();
        SnapshotDates = new ArrayList<LocalDate>();
        // List of all files and directories.
        filesList = directoryPath.listFiles();
        System.out.println("List of files and directories in the specified directory:");
        Scanner ScannerContents = null;
        boolean ParsedOne = false;
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
                // Currently not working, needs default constructor for Semester.
                // Semester semester = new Semester();
                Date = LocalDate.of(Integer.parseInt(FilenameParts[0]), Integer.parseInt(FilenameParts[1]),
                        Integer.parseInt(FilenameParts[2]));
                System.out.println("Date : " + Date);
                SnapshotDates.add(Date);
                // Reads the CSV file.
                Reader CSVFile = Files.newBufferedReader(Paths.get(file.getPath()));
                // Parses the CSV file into something that can be worked with.
                CSVParser parser = CSVParser.parse(CSVFile, CSVFormat.RFC4180);
                List<CSVRecord> csvRecords = parser.getRecords();
                // Offering class needs columns C, D, W, X: 2, 3, 22, 23
                // Section class needs columns A, B, G, H, I, U: 0, 1, 6, 7, 8, 20
                // Needs to sort all of the items into sections, offerings and semesters.
                String LastCRSE = "";
                // Create blank offering.
                Offering offering = new Offering();
                // Create blank section.
                Section section = new Section();
                for (int i = 1; i < csvRecords.size(); i++) {
                    CSVRecord csvRecord = csvRecords.get(i);
                    // Grab relavent items from the CSV.
                    int Seats = Integer.parseInt(csvRecord.get(0));
                    int CRN = Integer.parseInt(csvRecord.get(1));
                    String SUBJ = csvRecord.get(2);
                    String CRSE = csvRecord.get(3);
                    int XListCap = Integer.parseInt(csvRecord.get(6));
                    int ENR = Integer.parseInt(csvRecord.get(7));
                    String Link = csvRecord.get(8);
                    String Instructor = csvRecord.get(20);
                    int OverallCap = Integer.parseInt(csvRecord.get(6));
                    int OverallEnr = Integer.parseInt(csvRecord.get(23));
                    // Create new offering if the course is not equal to the previous course.
                    if (CRSE != LastCRSE) {
                        // Add the offering to the semester when creating the new offering if it's not
                        // the first offering created.
                        if (i > 1) {
                            // Currently not working, need a way to add the previously created offering into
                            // the semester before a new offering is created but only then.
                            // semester.AddOffering(offering);
                        }
                        // Create a new offering if the Last course is not the same as the current one.
                        offering = new Offering();
                    }
                    // Add relavent items to the section
                    if (Link.length() == 2) {
                        if (Link.charAt(1) == '1') {
                            section = new Section(CRN, Seats, XListCap, ENR, Instructor, Link);
                        }
                    }
                    // Add newly created section to the offering
                    // Not working currently, needs method to add single section.
                    // offering.AddSection(section);
                    System.out.print(Seats + " "); // Seats
                    System.out.print(CRN + " "); // CRN
                    System.out.print(SUBJ + " "); // SUBJ
                    System.out.print(CRSE + " "); // CRSE
                    System.out.print(XListCap + " "); // XLIST CAP
                    System.out.print(ENR + " "); // ENR
                    System.out.print(Link + " "); // LINK
                    System.out.print(Instructor + " "); // INSTRUCTOR
                    System.out.print(OverallCap + " "); // OVERALL CAP
                    System.out.print(OverallEnr + " "); // OVERALL ENR
                    System.out.println();
                    // Set the last course so that sections can be properly added to the offering
                    LastCRSE = CRSE;
                }
            }
            System.out.println("File path: " + file.getAbsolutePath());
            /*
             * ScannerContents = new Scanner(file);
             * String input;
             * StringBuffer FileContents = new StringBuffer();
             * while (ScannerContents.hasNextLine()) {
             * input = ScannerContents.nextLine();
             * FileContents.append(input + " ");
             * }
             * // System.out.println("Contents of the file: " + FileContents.toString());
             */
            System.out.println(" ");
            history.setSnapShotDate(SnapshotDates);
        }
        return history;
    }
}