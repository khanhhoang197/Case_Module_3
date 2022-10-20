package com.khanhhoang.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

public class Product {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String image;
    private String describes;

    public Product() {
    }

    public Product(String name, int price, int quantity, String image, String describes) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.describes = describes;
    }

    public Product(int id, String name, int price, int quantity, String image, String describes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.describes = describes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotEmpty(message = "Tên sản phẩm không được để trống")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(100000)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Min(1)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @NotEmpty(message = "Hình ảnh không được để trống")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                '}';
    }
}
