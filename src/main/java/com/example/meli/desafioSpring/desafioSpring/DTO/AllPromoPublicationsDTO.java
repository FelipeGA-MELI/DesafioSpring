package com.example.meli.desafioSpring.desafioSpring.DTO;

import com.example.meli.desafioSpring.desafioSpring.model.Publications;
import java.util.List;

public class AllPromoPublicationsDTO extends UserIdAndNameDTO {
    private List<Publications> posts;

    public List<Publications> getPosts() {
        return posts;
    }

    public void setPosts(List<Publications> posts) {
        this.posts = posts;
    }
}
