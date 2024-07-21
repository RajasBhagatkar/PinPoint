package com.pinpoint.PinPoint.services.Impl;

import com.pinpoint.PinPoint.entity.Locality;
import com.pinpoint.PinPoint.entity.Pincode;
import com.pinpoint.PinPoint.repository.LocalityRepository;
import com.pinpoint.PinPoint.repository.PincodeRepository;
import com.pinpoint.PinPoint.services.PincodeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class PincodeServiceImpl implements PincodeService {
    private final PincodeRepository pincodeRepository;
    private final LocalityRepository localityRepository;
    Logger logger = LoggerFactory.getLogger(PincodeServiceImpl.class);

    @Override
    public boolean insertPincodeService() {
        try {
//            Load the Excel file
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\RajasB\\Downloads\\pincode.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            // get the first sheet
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Interate through the rows and cells;
//            int lastRow = sheet.getLastRowNum();
            for (int i = 1; i < 10; i++) {
                XSSFRow row = sheet.getRow(i);

                Pincode pincode = new Pincode();
                pincode.setCreatedDate(new Date());
                pincode.setUpdatedDate(new Date());
                Locality locality = new Locality();
                locality.setUpdatedDate(new Date());
                locality.setCreatedDate(new Date());

                for (int j = 0; j < row.getLastCellNum(); j++) {

                    XSSFCell cell = row.getCell(j);

                    if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                        String cellValue = cell.getStringCellValue();
                        // circle name (string)
                        if (j == 0) {
                            pincode.setCircleName(cellValue);
                        }
                        // region name (string)
                        else if (j == 1) {
                            pincode.setRegionName(cellValue);
                        }
                        // division name (string)
                        else if (j == 2) {
                            pincode.setDivisionName(cellValue);
                        }
                        // office name (string)
                        // locality
                        else if (j == 3) {
                            if (cellValue.contains(" B.O")) {
                                String output = cellValue.replaceAll("B\\.O$", "");
                                locality.setLocality(output);
//                                System.out.print(output + " | ");
                            } else if (cellValue.contains(" BO")) {
                                String output = cellValue.replaceAll("BO$", "");
                                locality.setLocality(output);
//                                System.out.print(output + " | ");
                            } else if (cellValue.contains(" S.O")) {
                                String output = cellValue.replaceAll("S\\.O$", "");
                                locality.setLocality(output);
//                                System.out.print(output + " | ");
                            } else if (cellValue.contains(" SO")) {
                                String output = cellValue.replaceAll("SO$", "");
                                locality.setLocality(output);
//                                System.out.print(output + " | ");
                            } else {
                                locality.setLocality(cellValue);
//                                System.out.print(cellValue + " | ");
                            }

                        }
                        // district (string)
                        else if (j == 7) {
                            pincode.setDistrict(cellValue);
                        }
                        // state (string)
                        else if (j == 8) {
                            pincode.setState(cellValue);
                        }

                    } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                        // pincode (integer)
                        if (j == 4) {
                            Integer pincodeNum = (int) cell.getNumericCellValue();
//                            System.out.println(pincodeNum);
                            pincode.setPincode(pincodeNum);
                            locality.setPincode(pincodeNum);
//                            System.out.print(pincodeNum + " | ");
                        }
                        // latitude (double)
                        else if (j == 9) {
                            double numeric = cell.getNumericCellValue();
                            pincode.setLatitude(numeric);
//                            System.out.print(numeric + " | ");

                        }
                        // longitude (double)
                        else if (j == 10) {
                            double numeric = cell.getNumericCellValue();
                            pincode.setLongitude(numeric);
//                            System.out.print(numeric + " | ");
                        }

                    }
                }
//                System.out.println(pincode.toString());
                pincodeRepository.save(pincode);
                localityRepository.save(locality);
//                System.out.println("======================");
//                System.out.println(locality.toString());
            }

            return true;
        } catch (Exception e) {
//            System.out.println();
            System.out.println(e.getMessage());
            System.out.println("Error reading excel file:");
            return false;
        }
    }

    @Override
    public String testService() {
        return "Working....";
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<List<Locality>> printLocalities(int start, int end) throws Exception {
        try {
            logger.info("current thread - {}", Thread.currentThread().getName());
            logger.info("for range ({} - {})", start, end);

            List<Locality> result = new ArrayList<>();
            List<Pincode> pincodeList = new ArrayList<>();

            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\RajasB\\Downloads\\pincode.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            // get the first sheet
            XSSFSheet sheet = workbook.getSheetAt(0);

            if (end > sheet.getLastRowNum())
                throw new ArrayIndexOutOfBoundsException("end is greater than last row number");

            for (int i = start; i < end; i++) {

                if (i > sheet.getLastRowNum()) break;

                XSSFRow row = sheet.getRow(i);

                Pincode pincode = new Pincode();
                pincode.setCreatedDate(new Date());
                pincode.setUpdatedDate(new Date());

                Locality locality = new Locality();
                locality.setUpdatedDate(new Date());
                locality.setCreatedDate(new Date());

                for (int j = 0; j < row.getLastCellNum(); j++) {

                    XSSFCell cell = row.getCell(j);

                    if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                        String cellValue = cell.getStringCellValue();
                        // circle name (string)
                        if (j == 0) {
                            pincode.setCircleName(cellValue);
                        }
                        // region name (string)
                        else if (j == 1) {
                            pincode.setRegionName(cellValue);
                        }
                        // division name (string)
                        else if (j == 2) {
                            pincode.setDivisionName(cellValue);
                        }
                        // office name (string)
                        // locality
                        else if (j == 3) {
                            if (cellValue.contains(" B.O")) {
                                String output = cellValue.replaceAll("B\\.O$", "");
                                locality.setLocality(output);
//                                System.out.print(output + " | ");
                            } else if (cellValue.contains(" BO")) {
                                String output = cellValue.replaceAll("BO$", "");
                                locality.setLocality(output);
//                                System.out.print(output + " | ");
                            } else if (cellValue.contains(" S.O")) {
                                String output = cellValue.replaceAll("S\\.O$", "");
                                locality.setLocality(output);
//                                System.out.print(output + " | ");
                            } else if (cellValue.contains(" SO")) {
                                String output = cellValue.replaceAll("SO$", "");
                                locality.setLocality(output);
//                                System.out.print(output + " | ");
                            } else {
                                locality.setLocality(cellValue);
//                                System.out.print(cellValue + " | ");
                            }

                        }
                        // district (string)
                        else if (j == 7) {
                            pincode.setDistrict(cellValue);
                        }
                        // state (string)
                        else if (j == 8) {
                            pincode.setState(cellValue);
                        }

                    } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                        // pincode (integer)
                        if (j == 4) {
                            Integer pincodeNum = (int) cell.getNumericCellValue();
//                            System.out.println(pincodeNum);
                            pincode.setPincode(pincodeNum);
                            locality.setPincode(pincodeNum);
//                            System.out.print(pincodeNum + " | ");
                        }
                        // latitude (double)
                        else if (j == 9) {
                            double numeric = cell.getNumericCellValue();
                            pincode.setLatitude(numeric);
//                            System.out.print(numeric + " | ");

                        }
                        // longitude (double)
                        else if (j == 10) {
                            double numeric = cell.getNumericCellValue();
                            pincode.setLongitude(numeric);
//                            System.out.print(numeric + " | ");
                        }

                        result.add(locality);
                        pincodeList.add(pincode);

                    }
                }
            }

//            localityRepository.saveAll(result);
//            pincodeRepository.saveAll(pincodeList);

            fileInputStream.close();

            return new AsyncResult<>(result).completable();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error reading excel file:");
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Integer getTotalRows() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\RajasB\\Downloads\\pincode.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            return sheet.getLastRowNum();
        } catch (IOException e) {
            logger.info("failed to iterate through  file please check if it exists");
            throw new IOException(e.getMessage());
        }

    }
}
