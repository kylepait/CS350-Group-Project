package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.beans.Transient;
import java.io.File;
import java.io.Reader;
import java.lang.reflect.Array;
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

    @Test
    public void WillPass() {
        assertEquals(0, 0);
    }

    @Test
    public void TestDateSeparation() {
        LocalDate Start, End;
        Start = LocalDate.of(2000, 10, 1);
        End = LocalDate.of(2000, 10, 15);
        assertThat(new Main().DaysBetween(Start, End), equalTo(14));
    }

    @Test
    public void TestGetPercentagePassed() {
        int Total = 100, Passed = 27;
        assertThat(new Main().GetPercentagePassed(Total, Passed), equalTo((Double) 0.27));
    }

    @Test
    public void TestSetSemesterDates() {
        String path = "src/test/data/History/202010";
        File dataDirectory = new File(path);
        ArrayList<History> PreviousSemestersData;
        File filesList[];
        filesList = dataDirectory.listFiles();
        LocalDate StartDate, EndDate;
        StartDate = LocalDate.of(2020, 3, 30);
        EndDate = LocalDate.of(2020, 8, 25);
        PreviousSemestersData = new ArrayList<History>();
        try {
            PreviousSemestersData.add(new Main().GetFileContents(dataDirectory.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        History hist = PreviousSemestersData.get(0);
        assertThat(hist.getStartDate(), equalTo(StartDate));
        assertThat(hist.getEndDate(), equalTo(EndDate));
    }

    @Test
    public void testInterpolationEquation() throws IOException {

        // test y=2x+1
        int y_guess013 = new Main().Interpolate(0.0, 1, 3.0, 7, 1.0);
        assertThat(y_guess013, is((int) 3));

        int y_guess029 = new Main().Interpolate(0, 1, 9, 19, 2);
        assertThat(y_guess029, is((int) 5));

        // test y=x
        int y_guessYX = new Main().Interpolate(0, 0, 5, 5, 3);
        assertThat(y_guessYX, is(3));

        // test y=-x
        int y_negX = new Main().Interpolate(-2, 2, 9, -9, 5);
        assertThat(y_negX, is(-5));

        // test that value is correct if dates are passed in wrong order
        int wrong_order = new Main().Interpolate(5, 5, 0, 0, 1);
        assertThat(wrong_order, is(1));

        // test function if given interpolation time is out of range
        int oob = new Main().Interpolate(2, 2, 4, 4, 1);
        assertThat(oob, is(1));
    }

    @Test
    public void testCalculateProjectedEnrollment()
    {
        //create offering with 3 sections
        Section section1 = new Section(1, 50, 20, 0, "Instructor1", "Room1", "Time1");
        Section section2 = new Section(2, 30, 10, 0, "Instructor2", "Room2", "Time2");
        Section section3 = new Section(3, 20, 5, 23, "Instructor3", "Room3", "Time3");

        List<Section> sections = Arrays.asList(section1, section2, section3);
        Offering offering = new Offering(sections, "COMP101", "Introduction to Computer Science", 100, 35, 0);
        
        //calculate projected enrollement
        int projectedEnrollment = 0;
        for (Section section : sections)
        {
            projectedEnrollment += Math.min(section.getMaxEnrollment() - section.getCurrentEnrollment(), section.getEnrollments());
        }

        //check that the result is correct
        assertEquals(85, projectedEnrollment);
    }

}