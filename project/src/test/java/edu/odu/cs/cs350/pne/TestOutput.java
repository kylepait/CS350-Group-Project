package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class TestOutput
{
    @Test
    public void testTxtOutput() throws IOException
    {
        //prep test data
        List<String> expectedOutput = Arrays.asList("Output to txt test");

        //output to txt file
        Output.outputToTxt(expectedOutput, "test-output.txt");

        //read from txt file
        List<String> actualOutput = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("test-output.txt")));
        {
            while (scanner.hasNextLine())
            {
                actualOutput.add(scanner.nextLine());
            }
        }

        //compare expected vs actual
        assertEquals(expectedOutput, actualOutput);

        //clean up test file
        File file = new File("test-output.txt");
        file.delete();
    }

    @Test
    public void testExcelOutput() throws IOException
    {
        //prep data
        List<List<String>> expectedOutput = new ArrayList<>();
        expectedOutput.add(Arrays.asList("Output", "to", "Excel", "test"));

        //output to excel
        Output.outputToExcel(expectedOutput, "test-output.xlsx");

        //read from excel
        List<List<String>> actualOutput = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(new File("test-output.xlsx")))
        {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet)
            {
                rowValues.add(cell.toString());
            }

            actualOutput.add(rowValues);
        }
    }

        //compare expected vs actual
        assertEquals(expectedOutput, actualOutput);

        //clean up test file
        File file = new File("test-output.xlsx");
        file.delete();
}