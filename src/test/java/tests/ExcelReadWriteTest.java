package tests;

import org.testng.annotations.Test;
import utilities.ExcelUtility;

public class ExcelReadWriteTest
{

    @Test
    public void excelTest(){
        ExcelUtility excelUtility = new ExcelUtility();
        System.out.println(excelUtility.getColumnData("Sheet1", 0).toString());
        System.out.println(excelUtility.getRowData("Sheet1", 0).toString());
    }
}
