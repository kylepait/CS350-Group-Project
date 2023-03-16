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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataImport {
    private File filesList[];
    private ArrayList<LocalDate> SnapshotDates;

    DataImport() {
        filesList = null;
    }

    public History GetFileNames(String FilePath) throws IOException {
        // Creating a File object for directory
        File directoryPath = new File(FilePath);
        LocalDate Date = LocalDate.now();
        History history = new History();
        Section section = new Section();
        SnapshotDates = new ArrayList<LocalDate>();
        // List of all files and directories
        filesList = directoryPath.listFiles();
        System.out.println("List of files and directories in the specified directory:");
        Scanner ScannerContents = null;
        boolean ParsedOne = false;
        for (File file : filesList) {
            // System.out.println("File name: " + file.getName());
            String Filename = FilenameUtils.removeExtension(file.getName());
            String[] FilenameParts = Filename.split("-");
            if (FilenameParts.length == 3) {
                Date = LocalDate.of(Integer.parseInt(FilenameParts[0]), Integer.parseInt(FilenameParts[1]),
                        Integer.parseInt(FilenameParts[2]));
                System.out.println("Date : " + Date);
                SnapshotDates.add(Date);
                Reader CSVFile = Files.newBufferedReader(Paths.get(file.getPath()));
                CSVParser parser = CSVParser.parse(CSVFile, CSVFormat.RFC4180);
                List<CSVRecord> csvRecords = parser.getRecords();
                // Offering class needs columns C, D, W, X: 2, 3, 22, 23
                // Section class needs columns A, B, G, H, I, U: 0, 1, 6, 7, 8, 20
                for (int i = 1; i < csvRecords.size(); i++) {
                    CSVRecord csvRecord = csvRecords.get(i);
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
                }
            }
            System.out.println("File path: " + file.getAbsolutePath());
            ScannerContents = new Scanner(file);
            String input;
            StringBuffer FileContents = new StringBuffer();
            while (ScannerContents.hasNextLine()) {
                input = ScannerContents.nextLine();
                FileContents.append(input + " ");
            }
            // System.out.println("Contents of the file: " + FileContents.toString());
            System.out.println(" ");
            history.setSnapShotDate(SnapshotDates);

        }
        return history;
    }
}