package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.FilenameUtils;
import java.time.LocalDate;

public class DataImport {
    private File filesList[];

    DataImport() {
        filesList = null;
    }

    public void GetFileNames(String FilePath) throws IOException {
        // Creating a File object for directory
        File directoryPath = new File(FilePath);
        History history = new History();
        // List of all files and directories
        filesList = directoryPath.listFiles();
        System.out.println("List of files and directories in the specified directory:");
        Scanner ScannerContents = null;
        for (File file : filesList) {
            // System.out.println("File name: " + file.getName());
            String Filename = FilenameUtils.removeExtension(file.getName());
            String[] FilenameParts = Filename.split("-");
            if (FilenameParts.length == 3) {
                LocalDate Date = LocalDate.of(Integer.parseInt(FilenameParts[0]), Integer.parseInt(FilenameParts[1]),
                        Integer.parseInt(FilenameParts[2]));
                System.out.println("Date : " + Date);
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
        }
    }
}