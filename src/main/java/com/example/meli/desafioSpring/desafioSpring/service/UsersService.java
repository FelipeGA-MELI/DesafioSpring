package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.AllFollowersDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.AllFollowingDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.NumberOfFollowers;

public interface UsersService {
    void followSellerService(Integer userId, Integer userIdToFllow);

    NumberOfFollowers getNumberFollowersService(Integer userId);

    AllFollowersDTO getFollowersService(Integer userId, String order);

    AllFollowingDTO getFollowedByService(Integer userId, String order);

    void unfollowSellerService(Integer userId, Integer userIdToUnfollow);
}
