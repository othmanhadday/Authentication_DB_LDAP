package com.oth.stageapp.helper;

import com.oth.stageapp.entities.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Product> excelToProduct(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            List<Product> products = new ArrayList<Product>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                //skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Product product = new Product();

                int cellIndex = 0;
                Iterator<Cell> cells = currentRow.iterator();
                while (cells.hasNext()) {
                    Cell currentCell = cells.next();

                    switch (cellIndex) {
                        case 0:
                            product.setId((long) currentCell.getNumericCellValue());
                            break;

                        case 1:
                            product.setProduct_name(currentCell.getStringCellValue());
                            break;

                        case 2:
                            product.setPrice(currentCell.getNumericCellValue());
                            break;

                        case 3:
                            product.setCategory(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIndex++;
                }
                products.add(product);
            }
            workbook.close();

            return products;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("fail to parse Excel file : " + e.getMessage());
        }
    }
}
