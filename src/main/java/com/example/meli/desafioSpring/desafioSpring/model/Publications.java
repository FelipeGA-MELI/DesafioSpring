package com.example.meli.desafioSpring.desafioSpring.model;

import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationWithUserIdDTO;

import java.util.List;

public class Publications {
    private Integer id_post;
    private String date;
    private List<Products> detail;
    private Integer category;
    private double price;
    private Boolean hasPromo;
    private double discount;

    public Publications() { }

    public Publications(PublicationWithUserIdDTO publicationWithUserIdDTO) {
        this.id_post = publicationWithUserIdDTO.getId_post();
        this.date = publicationWithUserIdDTO.getDate();
        this.detail = publicationWithUserIdDTO.getDetail();
        this.category = publicationWithUserIdDTO.getCategory();
        this.price = publicationWithUserIdDTO.getPrice();
        this.hasPromo = publicationWithUserIdDTO.getHasPromo();
        this.discount = publicationWithUserIdDTO.getDiscount();
    }

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Products> getDetail() {
        return detail;
    }

    public void setDetail(List<Products> detail) {
        this.detail = detail;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
