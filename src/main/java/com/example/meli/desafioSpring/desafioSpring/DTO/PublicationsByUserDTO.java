package com.example.meli.desafioSpring.desafioSpring.DTO;

import com.example.meli.desafioSpring.desafioSpring.model.Publications;

import java.util.List;

public class PublicationsByUserDTO {
    private Integer userId;
    private List<Publications> posts;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Publications> getPosts() {
        return posts;
    }

    public void setPosts(List<Publications> posts) {
        this.posts = posts;
    }
}
