package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;

public interface UsersService {
    public void followSellerService(Integer userId, Integer userIdToFllow) throws DataBaseReadException;
}
