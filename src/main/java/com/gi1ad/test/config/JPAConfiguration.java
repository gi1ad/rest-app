package com.gi1ad.test.config;


import com.gi1ad.test.service.ProductServiceImpl;
import com.gi1ad.test.service.ProductService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.gi1ad" })
@PropertySource("classpath:application.properties")
public class JPAConfiguration {

    @Bean
    public ProductService priceService(){
        return new ProductServiceImpl();
    }
}
