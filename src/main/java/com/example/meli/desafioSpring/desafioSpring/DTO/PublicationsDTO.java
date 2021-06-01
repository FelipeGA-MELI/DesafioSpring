package com.example.meli.desafioSpring.desafioSpring.DTO;

import java.util.Date;
import java.util.List;

public class PublicationsDTO {
    private Integer id_post;
    private Date date;
    private List<ProductsDTO> detail;
    private Integer category;
    private double price;
    private Boolean hasPromo;
    private double discount;

    public PublicationsDTO() { }

    public PublicationsDTO(PublicationWithUserIdDTO publicationWithUserIdDTO) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ProductsDTO> getDetail() {
        return detail;
    }

    public void setDetail(List<ProductsDTO> detail) {
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
