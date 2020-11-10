package com.gi1ad.test.batch;

import com.gi1ad.test.domain.Product;
import com.gi1ad.test.repository.ProductRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class DBWriter implements ItemWriter<Product> {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void write(List<? extends Product> products) throws Exception {
        System.out.println("Products data saved" + products + "\n" +
                "number of records" + " " + (long) products.size());
        productRepository.saveAll(products);

    }


}
