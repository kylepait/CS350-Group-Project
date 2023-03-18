package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.time.LocalDate;
import java.util.Scanner;

public class TestMain {
    @Test
    public void TestGetFileContentsNoDataTxt() {
        String path = "src/test/data/History/199010";
        File dataDirectory = new File(path);
        IOException ThrownMessage;
        Exception exception = assertThrows(IOException.class, () -> {
            new Main().GetFileContents(dataDirectory.getAbsolutePath());
        });

        String expectedMessage = "Missing dates.txt in " + dataDirectory.getName();
        String actualMessage = exception.getMessage();

        assertThat(actualMessage, equalTo(expectedMessage));
    }

    @Test
    public void TestGetFileContentsNotEnoughSnapshots() {
        String path = "src/test/data/History/199020";
        File dataDirectory = new File(path);
        IOException ThrownMessage;
        Exception exception = assertThrows(IOException.class, () -> {
            new Main().GetFileContents(dataDirectory.getAbsolutePath());
        });

        String expectedMessage = "Insufficient snapshots in " + dataDirectory.getName();
        String actualMessage = exception.getMessage();

        assertThat(actualMessage, equalTo(expectedMessage));
    }

    @Test
    public void TestGetFileNumSections() {
        String path = "src/test/data/History/202010";
        File dataDirectory = new File(path);
        File filesList[];
        filesList = dataDirectory.listFiles();
        int Sections = 0, SectionsFromFile = 0;
        ArrayList<History> PreviousSemestersData;
        PreviousSemestersData = new ArrayList<History>();
        try {
            PreviousSemestersData.add(new Main().GetFileContents(dataDirectory.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        History hist = PreviousSemestersData.get(0);
        for (int i = 0; i < hist.getSemester().size(); i++) {
            Semester semes = hist.getSemesterByIndex(i);
            // System.out.println(semes);
            List<Offering> Off = semes.getOfferingList();
            for (int j = 0; j < Off.size(); j++) {
                // System.out.println(CRSELst.get(j));
                for (Section sect : Off.get(j).getSection()) {
                    Sections++;
                }
            }
            try {
                File file = filesList[i];
                // Get date of snapshot from filename.
                Reader CSVFile = Files.newBufferedReader(Paths.get(file.getPath()));
                CSVParser parser = CSVParser.parse(CSVFile, CSVFormat.RFC4180);
                List<CSVRecord> csvRecords = parser.getRecords();
                for (int j = 1; j < csvRecords.size(); j++) {
                    CSVRecord csvRecord = csvRecords.get(j);
                    String Link = csvRecord.get(8);
                    if (Link.length() == 2) {
                        if (Link.charAt(1) == '1') {
                            SectionsFromFile++;
                        }
                    } else {
                        SectionsFromFile++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertThat(Sections, equalTo(SectionsFromFile));
        }

    }

    @Test
    public void TestGetFileSnapshotDates() {
        String path = "src/test/data/History/202010";
        File dataDirectory = new File(path);
        ArrayList<History> PreviousSemestersData;
        File filesList[];
        filesList = dataDirectory.listFiles();
        LocalDate Date = LocalDate.now();
        PreviousSemestersData = new ArrayList<History>();
        try {
            PreviousSemestersData.add(new Main().GetFileContents(dataDirectory.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        History hist = PreviousSemestersData.get(0);
        for (int i = 0; i < hist.getSnapShotDate().size(); i++) {
            String Filename = FilenameUtils.removeExtension(filesList[i].getName());
            String[] FilenameParts = Filename.split("-");
            if (FilenameParts.length == 3) {
                Date = LocalDate.of(Integer.parseInt(FilenameParts[0]), Integer.parseInt(FilenameParts[1]),
                        Integer.parseInt(FilenameParts[2]));
            }
            assertThat(hist.getSnapShotByIndex(i), equalTo(Date));
        }

    }
}