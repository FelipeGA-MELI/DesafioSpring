package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationWithUserIdDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationsByUserDTO;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;

public interface ProductsService {
    void createPublicationService(PublicationWithUserIdDTO publication) throws DataBaseWriteException, DataBaseReadException, UserNotFoundException;

    PublicationsByUserDTO getPublicationsByUserService(Integer userId) throws DataBaseReadException, UserNotFoundException;
}
