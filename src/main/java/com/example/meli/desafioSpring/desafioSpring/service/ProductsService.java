package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationWithUserIdDTO;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;

public interface ProductsService {
    public void createPublicationService(PublicationWithUserIdDTO publication) throws DataBaseWriteException, DataBaseReadException, UserNotFoundException;
}
