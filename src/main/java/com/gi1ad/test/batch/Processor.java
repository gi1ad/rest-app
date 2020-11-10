package com.gi1ad.test.batch;

import com.gi1ad.test.domain.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component

public class Processor implements ItemProcessor<Product, Product> {



    @Override
    public Product process(Product product) throws Exception {
        product.setId(product.getId());
        product.setName(product.getName());
        product.setDate(new Date());
        return product;
    }

}
