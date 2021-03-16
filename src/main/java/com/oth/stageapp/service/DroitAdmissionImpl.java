package com.oth.stageapp.service;

import com.oth.stageapp.entities.Product;
import com.oth.stageapp.helper.ExcelHelper;
import com.oth.stageapp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DroitAdmissionImpl implements DroitAdmissionService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void saveData(MultipartFile file) {
        try {
            List<Product> products = ExcelHelper.excelToProduct(file.getInputStream());

            saveDroitAdmission(products);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    @Override
    public void saveDroitAdmission(List<Product> products) {
        for (Product product : products) {
            if(product.getId()==null){
                productRepository.save(product);
            }else {
                Optional<Product> product1 = productRepository.findById(product.getId());
                if (product1.isPresent() && product1.get().getId() == product.getId()){
                    productRepository.save(product);
                }else {
                    productRepository.save(product);
                }
            }
        }
    }

}
