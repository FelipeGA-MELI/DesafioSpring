package com.example.meli.desafioSpring.desafioSpring.DTO;

import java.util.List;

public class PublicationsByUserDTO {
    private Integer userId;
    private List<PublicationsDTO> posts;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<PublicationsDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PublicationsDTO> posts) {
        this.posts = posts;
    }
}
