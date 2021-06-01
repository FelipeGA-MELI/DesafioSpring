package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.AllFollowersDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.AllFollowingDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.NumberOfFollowers;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;

public interface UsersService {
    public void followSellerService(Integer userId, Integer userIdToFllow) throws DataBaseReadException, DataBaseWriteException, UserNotFoundException;

    public NumberOfFollowers getNumberFollowersService(Integer userId) throws UserNotFoundException, DataBaseReadException;

    public AllFollowersDTO getFollowersService(Integer userId) throws UserNotFoundException, DataBaseReadException;

    public AllFollowingDTO getFollowedByService(Integer userId) throws UserNotFoundException, DataBaseReadException;
}
