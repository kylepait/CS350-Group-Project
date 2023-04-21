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
import java.util.Hashtable;

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
        List<List<Double>> Data = new ArrayList<>();
        List<String> Header = new ArrayList<>();
        Hashtable<String, List<List<Double>>> HashData = new Hashtable<>();
        Header.add("Column 1");
        Header.add("Column 2");
        Header.add("Column 3");
        Header.add("Column 4");
        Data.add(Arrays.asList(0.0));
        Data.add(Arrays.asList(1.0));
        Data.add(Arrays.asList(2.0));
        Data.add(Arrays.asList(3.0));
        HashData.put("Page1", Data);
        expectedOutput.add(Header);
        expectedOutput.add(Arrays.asList("0.0", "1.0", "2.0", "3.0"));

        // output to excel
        Output.outputToExcel(Header, HashData, "TestOutputFile");

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
