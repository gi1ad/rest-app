package com.gi1ad.test.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Product {

    @Id
    private Integer id;

    private String name;

    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product(Integer id, String name, Date date, Integer priceId, String price, Date priceDate) {
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
