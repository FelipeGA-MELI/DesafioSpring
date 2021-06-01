package com.example.meli.desafioSpring.desafioSpring.DTO;

import java.util.List;

public class UsersDTO {
    private Integer userId;
    private String userName;
    private List<FollowersDTO> followers;
    private List<FollowersDTO> following;
    private List<PublicationsDTO> publications;
    private Boolean isSeller;

    public UsersDTO() {
    }

    public UsersDTO(UsersDTO usersDTO) {
        this.userId = usersDTO.getUserId();
        this.userName = usersDTO.getUserName();
        this.followers = usersDTO.getFollowers();
        this.following = usersDTO.getFollowing();
        this.publications = usersDTO.getPublications();
        this.isSeller = usersDTO.getSeller();
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

    public List<FollowersDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<FollowersDTO> followers) {
        this.followers = followers;
    }

    public List<FollowersDTO> getFollowing() {
        return following;
    }

    public void setFollowing(List<FollowersDTO> following) {
        this.following = following;
    }

    public List<PublicationsDTO> getPublications() {
        return publications;
    }

    public void setPublications(List<PublicationsDTO> publications) {
        this.publications = publications;
    }

    public Boolean getSeller() {
        return isSeller;
    }

    public void setSeller(Boolean seller) {
        isSeller = seller;
    }
}
