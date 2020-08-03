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
    private String docName;
    private byte[] file;

    public int getId() {
        return id;
    }



    public byte[] getFile() {return file;}
    @JsonProperty("file")
    public void setFile(byte[] file){this.file = file;}

    public String getDocName() {return docName;}

    @JsonProperty("docName")
    public void setDocName(String docName) {this.docName = docName;}

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
        return "/purchase/product?id=" + id;
    }

}
