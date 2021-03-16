package com.oth.stageapp.controller.droit_admission;

import com.oth.stageapp.entities.Product;
import com.oth.stageapp.helper.ExcelHelper;
import com.oth.stageapp.repositories.ProductRepository;
import com.oth.stageapp.service.DroitAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/control_commission/droit_admission")

public class DroitAdmissionController {

    @Autowired
    private DroitAdmissionService droitAdmissionService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "control_commission/droit_admission/index.html";
    }


    @PostMapping("/importFile")
    public String importExcelFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (ExcelHelper.hasExcelFormat(file)) {
            droitAdmissionService.saveData(file);
        }

        return "redirect:/control_commission/droit_admission/";
    }
}
