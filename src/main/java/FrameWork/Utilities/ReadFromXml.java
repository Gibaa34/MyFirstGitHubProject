package FrameWork.Utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ReadFromXml {

    public static List<String> UserRegistrationDetails(String path, String email) throws IOException {

        List<String> result = new ArrayList<>();
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(2);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(1).getPhysicalNumberOfCells();

        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            if (row.getCell(0).getStringCellValue().equals(email)) {
                for (int i = 0; i < cols; i++) {
                    try {
                        result.add(row.getCell(i).getStringCellValue());
                    } catch(RuntimeException excep) {
                        int num = (int) row.getCell(i).getNumericCellValue();
                        result.add(String.valueOf(num));
                    }
                }
            }
        }
        if(result.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("Personal details are null");
        }
        return result;
    }

    public static Collection ItemsInfo(String path) throws IOException {
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(1);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(1).getPhysicalNumberOfCells();

        String [][] obg= new String[rows-1][cols];
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            for (int j = 0; j < cols; j++) {
                obg[i-1][j]= sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return Arrays.asList(obg.clone());
    }


}
