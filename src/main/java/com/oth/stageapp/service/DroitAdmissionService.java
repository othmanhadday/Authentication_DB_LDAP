package com.oth.stageapp.service;

import com.oth.stageapp.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DroitAdmissionService {

    void saveData(MultipartFile file) throws IOException;

    void saveDroitAdmission(List<Product> products);

}
