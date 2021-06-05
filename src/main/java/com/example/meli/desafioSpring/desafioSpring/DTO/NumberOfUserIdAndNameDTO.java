package com.example.meli.desafioSpring.desafioSpring.DTO;

public class NumberOfUserIdAndNameDTO extends UserIdAndNameDTO {
    private Integer followers_count;

    public Integer getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(Integer followers_count) {
        this.followers_count = followers_count;
    }
}
