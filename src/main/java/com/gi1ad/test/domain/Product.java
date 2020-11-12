package com.gi1ad.test.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonIgnore
    private String inputId;


    private Boolean dbChanges;

    public Boolean getDbChanges() {
        return dbChanges;
    }

    public void setDbChanges(Boolean dbChanges) {
        this.dbChanges = dbChanges;
    }

    public String getInputId() {
        return inputId;
    }

    public void setInputId(String inputId) {
        this.inputId = inputId;
    }

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Price> priceList;

    public Set<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(Set<Price> priceList) {
        this.priceList = priceList;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Product(Integer id, String name, LocalDate date, Integer priceId, String price, Date priceDate) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", priceId="  +
                ", price='"  + '\'' +
                ", priceDate=" +
                '}';
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
