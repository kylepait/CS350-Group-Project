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
            }
            System.out.println("File path: " + file.getAbsolutePath());
            Reader CSVFile = Files.newBufferedReader(Paths.get(file.getPath()));
            CSVParser parser = CSVParser.parse(CSVFile, CSVFormat.RFC4180);
            List<CSVRecord> csvRecords = parser.getRecords();
            for (int i = 0; i < csvRecords.size(); i++) {
                CSVRecord csvRecord = csvRecords.get(i);
                for (int j = 0; j < csvRecord.size(); j++) {
                    System.out.print(csvRecord.get(j) + " ");
                }
                System.out.println();
            }

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