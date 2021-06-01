package com.example.meli.desafioSpring.desafioSpring.repository;
import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationsDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.UsersDTO;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;

public interface APIRepository {
    public UsersDTO findById(Integer userId) throws DataBaseReadException, UserNotFoundException;

    public void saveFollowersToDataBase(UsersDTO usersDTO, UsersDTO follower) throws DataBaseWriteException, DataBaseReadException;

    public String findUserNameById(Integer userId) throws DataBaseReadException, UserNotFoundException;

    public void createPublication(Integer userId,PublicationsDTO publication) throws DataBaseReadException, DataBaseWriteException, UserNotFoundException;
}
