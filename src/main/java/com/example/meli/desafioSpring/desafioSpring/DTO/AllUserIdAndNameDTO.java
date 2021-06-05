package com.example.meli.desafioSpring.desafioSpring.DTO;

import java.util.List;

public class AllUserIdAndNameDTO extends UserIdAndNameDTO {
    private List<UserIdAndNameDTO> followers;

    public List<UserIdAndNameDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserIdAndNameDTO> followers) {
        this.followers = followers;
    }
}
