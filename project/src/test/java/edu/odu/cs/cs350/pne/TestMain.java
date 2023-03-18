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

public class TestMain {
    @Test
    public void TestGetFileContentsNoDataTxt() {
        String path = "src/test/data/History/199010";
        File dataDirectory = new File(path);
        ArrayList<History> PreviousSemestersData;
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
        ArrayList<History> PreviousSemestersData;
        IOException ThrownMessage;
        Exception exception = assertThrows(IOException.class, () -> {
            new Main().GetFileContents(dataDirectory.getAbsolutePath());
        });

        String expectedMessage = "Insufficient snapshots in " + dataDirectory.getName();
        String actualMessage = exception.getMessage();

        assertThat(actualMessage, equalTo(expectedMessage));
    }
}