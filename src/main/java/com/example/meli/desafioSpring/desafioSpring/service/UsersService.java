package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.AllFollowersDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.AllFollowingDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.NumberOfFollowers;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;

public interface UsersService {
    void followSellerService(Integer userId, Integer userIdToFllow) throws DataBaseReadException, DataBaseWriteException, UserNotFoundException;

    NumberOfFollowers getNumberFollowersService(Integer userId) throws UserNotFoundException, DataBaseReadException;

    AllFollowersDTO getFollowersService(Integer userId) throws UserNotFoundException, DataBaseReadException;

    AllFollowingDTO getFollowedByService(Integer userId) throws UserNotFoundException, DataBaseReadException;

    void unfollowSellerService(Integer userId, Integer userIdToUnfollow) throws UserNotFoundException, DataBaseReadException, DataBaseWriteException;
}
