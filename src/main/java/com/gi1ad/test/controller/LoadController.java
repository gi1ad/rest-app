package com.gi1ad.test.controller;

import com.gi1ad.test.domain.Product;
import com.gi1ad.test.repository.PriceRepository;
import com.gi1ad.test.repository.ProductRepository;
import com.gi1ad.test.service.ProductService;
import com.gi1ad.test.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController

@RequestMapping("/products")
public class LoadController {

    @Autowired
    ProductServiceImpl service;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    ProductService priceService;


    @GetMapping("/load")
    public void load() throws IOException {
        service.saveData();
    }


    @GetMapping()
    public List<Product> getProducts(@RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return productRepository.findByDate(date);
    }


    @GetMapping("/statistics")
    @ResponseBody
    public String getCount() {
        service.updateProduct();
        return "Database contains : " + productRepository.count() + " products";
    }

    @GetMapping("/changes")
    public String getNumberOfChangesDB(){
        return "\n" +
                "Frequency of changes in the database : " + priceService.count(true);

    }


}
