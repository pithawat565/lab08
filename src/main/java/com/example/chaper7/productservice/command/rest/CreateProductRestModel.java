package com.example.chaper7.productservice.command.rest;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CreateProductRestModel{
    private String title;
    private BigDecimal price;
    private Integer quantity;

    public CreateProductRestModel(String title, BigDecimal price, int quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
