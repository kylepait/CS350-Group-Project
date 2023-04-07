package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Output {
    private static final String FILENAME = "output.txt";
    private static final String SHEETNAME = "output";
    private static final String[] HEADERS = { "Column 1", "Column 2", "Column 3" };

    public static void outputToTxt(List<String> lines, String Filename) throws IOException {
        File file = new File(Filename + ".txt");
        try (PrintWriter writer = new PrintWriter(file)) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }

    public static void outputToExcel(String[] Header, List<List<String>> data, String Filename) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(SHEETNAME);

        // write headers
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < Header.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(Header[i]);
        }

        // write data
        int rowNum = 1;
        for (List<String> row : data) {
            Row dataRow = sheet.createRow(rowNum++);
            for (int i = 0; i < row.size(); i++) {
                Cell cell = dataRow.createCell(i);
                cell.setCellValue(row.get(i));
            }
        }

        // write workbook to file
        try (FileOutputStream outputStream = new FileOutputStream(new File(Filename + ".xlsx"))) {
            workbook.write(outputStream);
        }
    }
}