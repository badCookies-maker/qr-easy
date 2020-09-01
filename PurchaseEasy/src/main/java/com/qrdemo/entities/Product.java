package com.qrdemo.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private double price;
    public String getUrlPayload;
    public int getId() {
        return id;
    }


    @JsonIgnoreProperties
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnoreProperties
    public double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrlPayload() {
        return "http://127.0.0.1:5500/product.html?id=" + id;
    }

}
