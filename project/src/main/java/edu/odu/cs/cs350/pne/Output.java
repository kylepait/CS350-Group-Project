package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.ss.util.CellRangeAddress;
import java.util.Hashtable;

public class Output {
    private static final String FILENAME = "output.txt";
    private static final String SHEETNAME = "output";
    private static final String[] HEADERS = { "Column 1", "Column 2", "Column 3" };

    public static void outputToTxt(String Header1, String Header2, List<List<String>> data, String Filename)
            throws IOException {
        File file = new File(Filename + ".txt");
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(Header1);
            writer.println(Header2);
            for (List<String> line : data) {
                writer.printf("%-7s%-11s%-10s%-3s\n", line.get(0), line.get(1), line.get(2), line.get(3));
            }
        }
    }

    public static void outputToExcel(List<String> Header, Hashtable<String, List<List<Double>>> data, String Filename)
            throws IOException {
        Enumeration enu = data.keys();
        String key;
        XSSFWorkbook workbook = new XSSFWorkbook();
        while (enu.hasMoreElements()) {
            key = (String) enu.nextElement();
            // System.out.println(key);
            XSSFSheet sheet = workbook.createSheet(key);

            // write headers
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < Header.size(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(Header.get(i));
            }

            // write data
            // System.out.println("HI1");
            int rowNum = 1, CellNum = 0;
            Row dataRow;
            for (List<Double> row : data.get(key)) {
                if (row != null) {
                    for (int i = 0; i < row.size(); i++) {
                        if (i + 1 >= rowNum) {
                            dataRow = sheet.createRow(rowNum++);
                        }
                        dataRow = sheet.getRow(i + 1);
                        Cell cell = dataRow.createCell(CellNum);
                        cell.setCellValue(row.get(i));
                    }
                }
                CellNum++;
            }
            // System.out.println("HI2");
            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, Header.size() + 1, 0, Header.size() + 30, 22);
            XSSFChart chart = drawing.createChart(anchor);
            chart.setTitleText("Chart Title");
            chart.setTitleOverlay(false);
            XDDFChartLegend legend = chart.getOrAddLegend();
            legend.setPosition(LegendPosition.TOP_RIGHT);
            XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
            bottomAxis.setTitle("Enrollment Period Passed");
            bottomAxis.setNumberFormat("Fraction");
            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
            leftAxis.setTitle("Enrollment");
            XDDFScatterChartData Chartdata = (XDDFScatterChartData) chart.createData(ChartTypes.SCATTER, bottomAxis,
                    leftAxis);
            List<List<Double>> SheetData = new ArrayList<>();
            SheetData = data.get(key);
            // System.out.println(key);
            if (SheetData != null) {
                // System.out.println("HI3");
                for (int i = 0; i < SheetData.size() / 2; i++) {
                    // System.out.println(SheetData.get(i * 2 + 1));
                    // System.out.println(i);
                    if ((SheetData.get(i * 2) != null) && (SheetData.get(i * 2 + 1) != null)) {
                        XDDFDataSource<String> passed = XDDFDataSourcesFactory.fromStringCellRange(sheet,
                                new CellRangeAddress(1, SheetData.get(i * 2).size(), i * 2, i * 2));
                        XDDFNumericalDataSource<Double> students = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
                                new CellRangeAddress(1, SheetData.get(i * 2 + 1).size(), i * 2 + 1, i * 2 + 1));
                        XDDFScatterChartData.Series series1 = (XDDFScatterChartData.Series) Chartdata.addSeries(passed,
                                students);
                        series1.setTitle(Header.get(i * 2 + 1), null);
                        series1.setSmooth(false);
                        series1.setMarkerStyle(MarkerStyle.DIAMOND);

                    }
                }
            }
            // System.out.println("HI5");
            chart.plot(Chartdata);
            // write workbook to file
            try (FileOutputStream outputStream = new FileOutputStream(new File(Filename + ".xlsx"))) {
                workbook.write(outputStream);
            }
        }

    }
}