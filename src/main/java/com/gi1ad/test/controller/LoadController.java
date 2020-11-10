package com.gi1ad.test.controller;

import com.gi1ad.test.domain.Price;
import com.gi1ad.test.repository.PriceRepository;
import com.gi1ad.test.repository.ProductRepository;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        Map<String,JobParameter> map = new HashMap<>();
        map.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameter = new JobParameters(map);
        JobExecution jobExecution = jobLauncher.run(job,jobParameter);
        System.out.println("Batch is running");
        while (jobExecution.isRunning()){
            System.out.println("...");
        }
        System.out.println("Data load " + jobExecution.getStatus());
        return jobExecution.getStatus();
    }


}
