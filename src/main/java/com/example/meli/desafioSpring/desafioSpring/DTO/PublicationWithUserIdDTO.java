package com.example.meli.desafioSpring.desafioSpring.DTO;

public class PublicationWithUserIdDTO extends PublicationsDTO {
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
