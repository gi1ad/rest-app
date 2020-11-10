package com.gi1ad.test.batch;

import com.gi1ad.test.domain.Price;
import com.gi1ad.test.domain.Product;
import com.gi1ad.test.repository.ProductRepository;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Iterator;


public class Reader implements ItemReader<Product> {


    @Autowired
    private ProductRepository productRepository;

    private Iterator<Product> iterator;

    @BeforeStep
    public void before(StepExecution stepExecution) {
        iterator = productRepository.findAll().iterator();
    }

    @Override
    public Product read() {
        if (iterator != null && iterator.hasNext()) {
            return iterator.next();
        } else {
            return null;
        }
    }


}
