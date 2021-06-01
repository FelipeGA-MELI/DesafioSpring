package com.example.meli.desafioSpring.desafioSpring.service;

import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationWithUserIdDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationsDTO;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;
import com.example.meli.desafioSpring.desafioSpring.repository.APIRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService{
    private APIRepository apiRepository;

    public ProductsServiceImpl(APIRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    @Override
    public void createPublicationService(PublicationWithUserIdDTO publication) throws DataBaseWriteException, DataBaseReadException, UserNotFoundException {
        PublicationsDTO publicationDTO = new PublicationsDTO(publication);
        Integer userId = publication.getUserId();

        apiRepository.createPublication(userId,publicationDTO);
    }
}
