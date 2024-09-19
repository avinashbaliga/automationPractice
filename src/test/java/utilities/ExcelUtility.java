package utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtility
{
    private static Workbook workbook = null;
    private static FileInputStream fileInputStream;

    public ExcelUtility()
    {
        try
        {
            fileInputStream = new FileInputStream("src/main/resources/data.xlsx");
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Row> getData(String sheetName)
    {
        List<Row> rows = new ArrayList<>();
        initiateWorkbookForReading();
        Sheet sheet = workbook.getSheet(sheetName);
        Iterator rowIterator = sheet.rowIterator();

        if (!rowIterator.hasNext())
            throw new RuntimeException("No rows/data are present in sheet: " + sheetName);

        while (rowIterator.hasNext())
        {
            rows.add((Row) rowIterator.next());
        }

        return rows;
    }

    public List<String> getColumnData(String sheetName, int columnIndex)
    {
        List<Row> rows = getData(sheetName);
        List<String> columnData = new ArrayList<>();

        for (Row row : rows)
        {
            columnData.add(row.getCell(columnIndex).getStringCellValue());
        }

        return columnData;
    }

    private void initiateWorkbookForReading()
    {
        if (workbook == null)
        {
            try
            {
                workbook = WorkbookFactory.create(fileInputStream);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public List<String> getRowData(String sheetName, int rowIndex)
    {
        List<Row> rows = getData(sheetName);
        List<String> rowData = new ArrayList<>();
        Iterator cellIterator = rows.get(rowIndex).cellIterator();

        while (cellIterator.hasNext())
            rowData.add(((Cell) (cellIterator.next())).getStringCellValue());

        return rowData;
    }
}
