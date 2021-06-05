package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.NumberOfPublicationsDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationWithUserIdDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationsByUserDTO;

public interface ProductsService {
    void createPublicationService(PublicationWithUserIdDTO publication, Boolean hasPromo);

    PublicationsByUserDTO getPublicationsByUserService(Integer userId, String order);

    NumberOfPublicationsDTO getNumberPublications(Integer userId);
}
