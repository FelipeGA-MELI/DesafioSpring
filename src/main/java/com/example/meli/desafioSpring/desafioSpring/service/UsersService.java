package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.AllUserIdAndNameDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.AllFollowingDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.NumberOfUserIdAndNameDTO;
import com.example.meli.desafioSpring.desafioSpring.model.Users;

public interface UsersService {
    void followSellerService(Integer userId, Integer userIdToFllow);

    NumberOfUserIdAndNameDTO getNumberFollowersService(Integer userId);

    AllUserIdAndNameDTO getFollowersService(Integer userId, String order);

    AllFollowingDTO getFollowedByService(Integer userId, String order);

    void unfollowSellerService(Integer userId, Integer userIdToUnfollow);

    void createUserService(Users user);
}
