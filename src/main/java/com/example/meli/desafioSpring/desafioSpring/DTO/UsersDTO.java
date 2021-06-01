package com.example.meli.desafioSpring.desafioSpring.DTO;

import java.util.List;

public class UsersDTO {
    private Integer userId;
    private String userName;
    private List<UsersDTO> followers;
    private List<UsersDTO> following;
    private PublicationsDTO publications;
    private Boolean isSeller;

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

    public List<UsersDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UsersDTO> followers) {
        this.followers = followers;
    }

    public List<UsersDTO> getFollowing() {
        return following;
    }

    public void setFollowing(List<UsersDTO> following) {
        this.following = following;
    }

    public PublicationsDTO getPublications() {
        return publications;
    }

    public void setPublications(PublicationsDTO publications) {
        this.publications = publications;
    }

    public Boolean getSeller() {
        return isSeller;
    }

    public void setSeller(Boolean seller) {
        isSeller = seller;
    }
}
