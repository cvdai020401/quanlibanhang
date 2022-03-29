package com.example.shoppingdai.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId", nullable = false)
    private Integer id;

    @NotEmpty(message = "Không để trống tên sản phẩm")
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Image", nullable = false)
    private String image;

    @NotNull(message = "Không để trống giá sản phẩm")
    @Min(value = 1, message = "Giá sản phẩm > 0")
    @Column(name = "Price", nullable = false)
    private Double price;

    @Column(name = "CreateDate", nullable = false)
    private LocalDate createDate = LocalDate.now();

    @Column(name = "Avaiable", nullable = false)
    private Boolean avaiable = true;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CategoryId", nullable = false)
    private Category categoryId;

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getAvaiable() {
        return avaiable;
    }

    public void setAvaiable(Boolean avaiable) {
        this.avaiable = avaiable;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", createDate=" + createDate +
                ", avaiable=" + avaiable +
                '}';
    }
}