package edu.odu.cs.cs350.pne;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DataImport instance = new DataImport();
        if (args[0] == null || args[0].trim().isEmpty()) {
            System.out.println("You need to specify a path!");
            return;
        } else {
            instance.GetFileNames(args[0]);
        }
    }
}