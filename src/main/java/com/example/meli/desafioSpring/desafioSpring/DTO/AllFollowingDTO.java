package com.example.meli.desafioSpring.desafioSpring.DTO;

import java.util.List;

public class AllFollowingDTO extends UserIdAndNameDTO {
    private List<UserIdAndNameDTO> followed;

    public List<UserIdAndNameDTO> getFollowing() {
        return followed;
    }

    public void setFollowing(List<UserIdAndNameDTO> followed) {
        this.followed = followed;
    }
}
