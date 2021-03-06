package com.example.meli.desafioSpring.desafioSpring.model;

import com.example.meli.desafioSpring.desafioSpring.DTO.UserIdAndNameDTO;

import java.util.List;

public class Users {
    private Integer userId;
    private String userName;
    private List<UserIdAndNameDTO> followers;
    private List<UserIdAndNameDTO> following;
    private List<Publications> publications;
    private Boolean isSeller;

    public Users() {
    }

    public Users(Users users) {
        this.userId = users.getUserId();
        this.userName = users.getUserName();
        this.followers = users.getFollowers();
        this.following = users.getFollowing();
        this.publications = users.getPublications();
        this.isSeller = users.getSeller();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserIdAndNameDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserIdAndNameDTO> followers) {
        this.followers = followers;
    }

    public List<UserIdAndNameDTO> getFollowing() {
        return following;
    }

    public void setFollowing(List<UserIdAndNameDTO> following) {
        this.following = following;
    }

    public List<Publications> getPublications() {
        return publications;
    }

    public void setPublications(List<Publications> publications) {
        this.publications = publications;
    }

    public Boolean getSeller() {
        return isSeller;
    }

    public void setSeller(Boolean seller) {
        isSeller = seller;
    }
}
