package com.oth.stageapp.controller.droit_admission;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/control_commission/droit_admission")

public class DroitAdmissionController {

    @GetMapping("/")
    public String index() {
        return "control_commission/droit_admission/index.html";
    }


    @PostMapping("/importFile")
    public String importExcelFile(@RequestParam("file")MultipartFile file) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet workSheet = workbook.getSheetAt(0);

        for (int index=0;index<workSheet.getPhysicalNumberOfRows();index++){
            if (index>0){
                XSSFRow row = workSheet.getRow(index);
                System.out.println(row.getCell(0).getNumericCellValue());
                System.out.println(row.getCell(1).getStringCellValue());
            }
        }

        return "redirect:/control_commission/droit_admission/";
    }

}
