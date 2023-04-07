package edu.odu.cs.cs350.pne;

import edu.odu.cs.cs350.pne.Output;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestOutput {
    @Test
    public void testTxtOutput() throws IOException {
        // prep test data
        List<List<String>> Data = new ArrayList<>();
        Data.add(Arrays.asList("Output", "to", "Excel", "test"));

        // output to txt file
        Output.outputToTxt("Header1", "Header2", Data, "test-output");

        // read from txt file
        List<String> actualOutput = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("test-output.txt"))) {
            while (scanner.hasNextLine()) {
                actualOutput.add(scanner.nextLine());
            }
        }
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("Header1");
        expectedOutput.add("Header2");
        expectedOutput.add("Output to         Excel     test");
        // compare expected vs actual
        assertEquals(expectedOutput, actualOutput);

        // clean up test file
        File file = new File("test-output.txt");
        file.delete();
    }

    @Test
    public void testExcelOutput() throws IOException {
        // prep data
        List<List<String>> expectedOutput = new ArrayList<>();
        List<List<String>> Data = new ArrayList<>();
        String[] Header = { "Column 1", "Column 2", "Column 3", "Column 4" };
        Data.add(Arrays.asList("Output", "to", "Excel", "test"));
        expectedOutput.add(Arrays.asList(Header));
        expectedOutput.add(Arrays.asList("Output", "to", "Excel", "test"));

        // output to excel
        Output.outputToExcel(Header, Data, "TestOutputFile");

        // read from excel
        List<List<String>> actualOutput = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(new File("TestOutputFile.xlsx"))) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                List<String> rowValues = new ArrayList<>();
                for (Cell cell : row) {
                    rowValues.add(cell.toString());
                }

                actualOutput.add(rowValues);
            }
        }

        // compare expected vs actual
        assertEquals(expectedOutput, actualOutput);

        // clean up test file
        File file = new File("output.xlsx");
        file.delete();
    }
}
