package com.example.meli.desafioSpring.desafioSpring.DTO;

import java.util.List;

public class AllFollowersDTO extends FollowersDTO {
    private List<FollowersDTO> followers;

    public List<FollowersDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<FollowersDTO> followers) {
        this.followers = followers;
    }
}
