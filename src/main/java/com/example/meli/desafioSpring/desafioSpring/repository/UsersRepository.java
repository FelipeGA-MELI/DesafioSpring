package com.example.meli.desafioSpring.desafioSpring.repository;

import com.example.meli.desafioSpring.desafioSpring.DTO.UsersDTO;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;

import java.util.List;

public interface UsersRepository {
    public UsersDTO findById(Integer userId) throws DataBaseReadException;

    public List<UsersDTO> findFollowers(Integer userId);

    public void DataBaseWrite(List<UsersDTO> usersDTO) throws DataBaseWriteException;
}
