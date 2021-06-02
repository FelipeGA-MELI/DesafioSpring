package com.example.meli.desafioSpring.desafioSpring.repository;
import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationsDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.UsersDTO;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;

import java.util.List;

public interface APIRepository {
    UsersDTO findById(Integer userId) throws DataBaseReadException, UserNotFoundException;

    void saveFollowersToDataBase(UsersDTO usersDTO, UsersDTO follower) throws DataBaseWriteException, DataBaseReadException;

    String findUserNameById(Integer userId) throws DataBaseReadException, UserNotFoundException;

    void createPublication(Integer userId, PublicationsDTO publication) throws DataBaseReadException, DataBaseWriteException, UserNotFoundException;

    List<PublicationsDTO> getAllPublicationsByUserId(Integer userId) throws DataBaseReadException, UserNotFoundException;
}
