package com.example.meli.desafioSpring.desafioSpring.repository;
import com.example.meli.desafioSpring.desafioSpring.DTO.UsersDTO;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;

public interface UsersRepository {
    public UsersDTO findById(Integer userId) throws DataBaseReadException, UserNotFoundException;

    public void saveFollowersToDataBase(UsersDTO usersDTO, UsersDTO follower) throws DataBaseWriteException;

    public String findUserNameById(Integer userId) throws DataBaseReadException, UserNotFoundException;
}
