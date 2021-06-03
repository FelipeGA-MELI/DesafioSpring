package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationWithUserIdDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationsByUserDTO;

public interface ProductsService {
    void createPublicationService(PublicationWithUserIdDTO publication);

    PublicationsByUserDTO getPublicationsByUserService(Integer userId);
}
