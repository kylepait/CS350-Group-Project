package edu.odu.cs.cs350.pne;

import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<History> Snapshots;
        ArrayList<LocalDate> Date;
        Snapshots = new ArrayList<History>();
        Date = new ArrayList<LocalDate>();
        DataImport instance = new DataImport();
        if (args[0] == null || args[0].trim().isEmpty()) {
            System.out.println("You need to specify a path!");
            return;
        } else {
            for (String Directory : args)
                Snapshots.add(instance.GetFileNames(Directory));
        }
        /*
         * for (History Snapshot : Snapshots) {
         * Date = Snapshot.getSnapShotDate();
         * for (LocalDate SnapDate : Date)
         * System.out.println("Snapshot Date: " + SnapDate);
         * }
         */
    }
}