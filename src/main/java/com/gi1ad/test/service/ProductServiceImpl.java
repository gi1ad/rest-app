package com.gi1ad.test.service;

import com.gi1ad.test.domain.Price;
import com.gi1ad.test.domain.Product;
import com.gi1ad.test.repository.PriceRepository;
import com.gi1ad.test.repository.ProductRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.IIOException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Long count(boolean changes) {
            return productRepository.count(changes);

    }

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceRepository priceRepository;

    String line = "";
    String line1 = null;

    public void saveData() throws IOException {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/main/Resources/product.csv"));
            String[] data;
            csvReader.readNext();
            while ((data = csvReader.readNext()) != null) {
                Product product = new Product();
                product.setInputId(data[0]);
                product.setName(data[1]);
                product.setDate(LocalDate.now());
                product.setDbChanges(true);
                productRepository.save(product);
                Price price = new Price();
                price.setInputId(data[2]);
                price.setPrice(data[3]);
                price.setDate(LocalDate.now());
                price.setProduct(product);
                priceRepository.save(price);
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/Resources/product.csv"));
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] data = line.split(",");
//                Product product = new Product();
//                product.setName(data[1]);
//                product.setDate(new Date());
//
//                Price price = new Price();
//                price.setDate(new Date());
//                price.setPrice(data[3]);
//                price.setProduct(product);
//                productRepository.save(product);
//                priceRepository.save(price);
            }
        } catch (IIOException | CsvValidationException e) {
            e.printStackTrace();
        }

    }


    public void updateProduct() {
        List<Product> products = productRepository.findAll();
        LocalDate date = LocalDate.now();
        for (Product product : products) {
            System.out.println("Before update" + product.getDbChanges());
            if (product.getDate().isAfter(date)) {
                product.setDbChanges(false);
                productRepository.save(product);
            }
        }
        for (Product product : products) {
            System.out.println("After update : " + product.getDbChanges());
        }

//
//      List<Product> products = productRepository.findAll();
//        products.stream().filter(product -> product.getDate().isAfter(date)).findFirst().map(product -> {
//          product.setDbChanges(false);
//          return productRepository.save(product);
//       });
//        productRepository.saveAll(products);
    }
}
