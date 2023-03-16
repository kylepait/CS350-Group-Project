package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.IOException;

public class DataImport {
    private File filesList[];

    DataImport() {
        filesList = null;
    }

    public void GetFileNames(String FilePath) {
        // Creating a File object for directory
        File directoryPath = new File(FilePath);
        // List of all files and directories
        filesList = directoryPath.listFiles();
        System.out.println("List of files and directories in the specified directory:");
        for (File file : filesList) {
            System.out.println("File name: " + file.getName());
            System.out.println("File path: " + file.getAbsolutePath());
            System.out.println(" ");
        }
    }
}