package com.example.meli.desafioSpring.desafioSpring.repository;

import com.example.meli.desafioSpring.desafioSpring.DTO.*;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

@Repository
public class APIRepositoryImpl implements APIRepository {
    List<UsersDTO> dataBase = dataBaseRead();

    @Override
    public UsersDTO findById(Integer userId) throws DataBaseReadException, UserNotFoundException {
        UsersDTO userFound;

        if(dataBase.isEmpty())
            throw new DataBaseReadException("Data base is null.");

        userFound = dataBase.stream().filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        return userFound;
    }

    @Override
    public void setFollower(UsersDTO usersDTO, UsersDTO userToFollow) throws DataBaseWriteException, DataBaseReadException, UserNotFoundException {
        if(dataBase.isEmpty())
            throw new DataBaseReadException("Data base is null.");

        UsersDTO userFiltered = dataBase.stream()
                .filter(user -> user.getUserId().equals(usersDTO.getUserId()))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found."));
        UsersDTO userToFollowFiltered = dataBase.stream()
                .filter(follower -> follower.getUserId().equals(userToFollow.getUserId()))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        dataBase.remove(userFiltered);
        dataBase.remove(userToFollowFiltered);
        dataBase.add(usersDTO);
        dataBase.add(userToFollow);

        dataBaseWrite(dataBase);
    }

    @Override
    public String findUserNameById(Integer userId) throws DataBaseReadException, UserNotFoundException {
        UsersDTO filteredUser;

        if(dataBase.isEmpty())
            throw new DataBaseReadException("Data base is null.");

        filteredUser = dataBase.stream().filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        return filteredUser.getUserName();
    }

    @Override
    public void createPublication(Integer userId, PublicationsDTO publication) throws DataBaseReadException, DataBaseWriteException, UserNotFoundException {
        List<PublicationsDTO> publicationsDTOList;
        UsersDTO filteredUser;

        if(dataBase.isEmpty())
            throw new DataBaseReadException("Data base is null.");

        filteredUser = dataBase.stream().filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        publicationsDTOList = filteredUser.getPublications();
        publicationsDTOList.add(publication);
        filteredUser.setPublications(publicationsDTOList);

        dataBase.remove(filteredUser);
        dataBase.add(filteredUser);

        dataBaseWrite(dataBase);

    }

    @Override
    public List<PublicationsDTO> getAllPublicationsByUserId(Integer userId) throws DataBaseReadException, UserNotFoundException {
        UsersDTO filteredUser = findById(userId);

        return filteredUser.getPublications();
    }

    private void dataBaseWrite(List<UsersDTO> usersDTOList) throws DataBaseWriteException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(Paths.get("user.json").toFile(),usersDTOList);
        } catch (IOException e) {
            throw new DataBaseWriteException("Couldnt write to database.");
        }
    }

    private List<UsersDTO> dataBaseRead() {
        File file = null;

        try {
            file = ResourceUtils.getFile("/Users/fgusmao/Downloads/desafioSpring/user.json");
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
