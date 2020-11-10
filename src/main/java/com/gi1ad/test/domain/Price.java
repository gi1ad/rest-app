package com.gi1ad.test.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Price {

    @Id
    private Integer id;

    private String price;

    private Date date;

    @OneToOne(optional = false)
    private Product product;

    public Price() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Price(Integer id, String price, Date date, Product product) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
