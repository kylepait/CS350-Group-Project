package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestMain {
    @Test
    public void TestGetFileContentsNoDataTxt() {
        String path = "src/test/data/History/202010";
        File dataDirectory = new File(path);
        ArrayList<History> PreviousSemestersData;
        PreviousSemestersData = new ArrayList<History>();
        try {
            PreviousSemestersData.add(new Main().GetFileContents(dataDirectory.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (History hist : PreviousSemestersData) {
            // System.out.println(hist.getSemester());
            for (int i = 0; i < hist.getSemester().size(); i++) {
                Semester semes = hist.getSemesterByIndex(i);
                System.out.println(semes.getSemesterCode());
                System.out.println(hist.getSnapShotByIndex(i));
                // System.out.println(semes);
                List<Offering> Off = semes.getOfferingList();
                List<String> CRSELst = semes.getCRSEList();
                for (int j = 0; j < Off.size(); j++) {
                    // System.out.println(CRSELst.get(j));
                    System.out.println("    CRSE: " + Off.get(j).getCRSE() + " SUBJ: " +
                            Off.get(j).getSUBJ()
                            + " ENRL: " + Off.get(j).getEnrollment() + " MaxENRL: " +
                            Off.get(j).getMaxEnrollment()
                            + " CurrENRL: " + Off.get(j).getCurrentEnrollment());
                    for (Section sect : Off.get(j).getSection()) {
                        System.out.println(
                                "        CRN: " + sect.getCRN() + " Seats Remaining: " +
                                        sect.getSeatsRemaining()
                                        + " XList Cap: " + sect.getCrossListCap() + " ENRL:" + sect.getEnrollments()
                                        + " XList Group: " + sect.getCrossListGroup() + " Instr: "
                                        + sect.getInstructor() + " Link: " + sect.getLink());
                    }
                }
            }
        }
    }
}