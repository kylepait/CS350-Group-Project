package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataImport {
    private File filesList[];

    DataImport() {
        filesList = null;
    }

    public void GetFileNames(String FilePath) throws IOException {
        // Creating a File object for directory
        File directoryPath = new File(FilePath);
        // List of all files and directories
        filesList = directoryPath.listFiles();
        System.out.println("List of files and directories in the specified directory:");
        Scanner ScannerContents = null;
        for (File file : filesList) {
            System.out.println("File name: " + file.getName());
            System.out.println("File path: " + file.getAbsolutePath());
            ScannerContents = new Scanner(file);
            String input;
            StringBuffer FileContents = new StringBuffer();
            while (ScannerContents.hasNextLine()) {
                input = ScannerContents.nextLine();
                FileContents.append(input + " ");
            }
            System.out.println("Contents of the file: " + FileContents.toString());
            System.out.println(" ");
        }
    }
}