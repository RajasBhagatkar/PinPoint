package com.pinpoint.PinPoint.controller;

import com.pinpoint.PinPoint.services.PincodeService;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttp;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.util.regex.Pattern;

@RestController
@RequiredArgsConstructor
public class testController {

    private final PincodeService pincodeService;

    @GetMapping("/")
    private ResponseEntity<?> getTest(){
        try{
//            Load the Excel file
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\RajasB\\Downloads\\pincode.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            // get the first sheet
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Interate through the rows and cells;
            int lastRow = sheet.getLastRowNum();
            for (int i = 341; i < 347; i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    XSSFCell cell = row.getCell(j);
                    if(cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                        String cellValue = cell.getStringCellValue();
                        if(cellValue.contains(" B.O")){
                            String output =cellValue.replaceAll("B\\.O$", "");
                            System.out.print(output + " | ");
                        }else if(cellValue.contains(" BO")){
                            String output =cellValue.replaceAll("BO$", "");
                            System.out.print(output + " | ");
                        }
                        else if(cellValue.contains(" S.O")){
                            String output =cellValue.replaceAll("S\\.O$", "");
                            System.out.print(output + " | ");
                        }

                        else if(cellValue.contains(" SO")){
                            String output =cellValue.replaceAll("SO$", "");
                            System.out.print(output + " | ");
                        }
                        else {
                            System.out.print(cellValue + " | ");
                        }
                    }else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
                        if(j == 4){
                            Integer numeric = (int) cell.getNumericCellValue();
                            System.out.print( numeric + " | ");
                        }else {
                            double numeric = cell.getNumericCellValue();
                            System.out.print( numeric + " | ");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }


            return new ResponseEntity<>("OK", HttpStatus.OK);
        }catch (Exception e){
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println("Error reading excel file:");
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }
    }

    @GetMapping("/insertData")
    private ResponseEntity<?> insertDB(){
        boolean result = pincodeService.insertPincodeService();
        if(result){
            System.out.println("completed!!");
        }
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
