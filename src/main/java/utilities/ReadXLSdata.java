package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

public class ReadXLSdata {

    @DataProvider (name = "LoginTest")
    public String[][] getLoginData(Method m ) throws IOException {
        String login = m.getName();

        File file = new File("src/main/resources/testdata/logindata.xlsx");
        FileInputStream fis = new FileInputStream(file);

        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(login);

        int totalRows = sheetName.getLastRowNum();
        System.out.println("totalRows " + totalRows);
        Row rowCells = sheetName.getRow(0);

        int totalCols = rowCells.getLastCellNum();
        System.out.println("totalCols " + totalCols);

        DataFormatter format = new DataFormatter();

        String loginData[][] = new String[totalRows][totalCols];

        for(int i=1; i< totalRows; i++){
            for(int j=0; j<totalCols; j ++){
                loginData[i][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));

                System.out.println(loginData[i][j]);
            }
        }
        return loginData;

    }

//    public static void main(String[] args) throws IOException {
//        ReadXLSdata red = new ReadXLSdata();
//        red.getLoginData("Login_Data");
//    }

}
