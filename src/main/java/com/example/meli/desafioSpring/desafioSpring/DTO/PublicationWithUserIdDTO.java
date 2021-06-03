package com.example.meli.desafioSpring.desafioSpring.DTO;

import com.example.meli.desafioSpring.desafioSpring.model.Publications;

public class PublicationWithUserIdDTO extends Publications {
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
