package com.example.meli.desafioSpring.desafioSpring.repository;

import com.example.meli.desafioSpring.desafioSpring.DTO.UsersDTO;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsersRepositoryImpl implements UsersRepository{
    @Override
    public UsersDTO findById(Integer userId) throws DataBaseReadException {
        List<UsersDTO> usersDTOSList = UsersDataBaseRead();
        List<UsersDTO> userFound;

        if(usersDTOSList.size() != 0) {
            userFound = usersDTOSList.stream().filter(user -> user.getUserId().equals(userId)).collect(Collectors.toList());
        } else {
            throw new DataBaseReadException("Data base is null!");
        }

        return userFound.get(0);
    }

    @Override
    public List<UsersDTO> findFollowers(Integer userId) {
        return null;
    }

    @Override
    public void writeToDataBase(List<UsersDTO> usersDTOList) throws DataBaseWriteException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<UsersDTO>> typeRef = new TypeReference<List<UsersDTO>>() { };

        try {
            objectMapper.writeValue(new File("classpath:users.json"),usersDTOList);
        } catch (IOException e) {
            throw new DataBaseWriteException("Couldnt write to database.");
        }
    }


    private List<UsersDTO> UsersDataBaseRead() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<UsersDTO>> typeRef = new TypeReference<>() { };
        List<UsersDTO> usersDTOList = new LinkedList<>();

        try {
            usersDTOList = objectMapper.readValue(file,typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usersDTOList;
    }
}
