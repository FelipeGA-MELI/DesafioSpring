package com.example.meli.desafioSpring.desafioSpring.DTO;

import java.util.List;

public class AllFollowingDTO extends FollowersDTO {
    private List<FollowersDTO> followed;

    public List<FollowersDTO> getFollowing() {
        return followed;
    }

    public void setFollowing(List<FollowersDTO> followed) {
        this.followed = followed;
    }
}
