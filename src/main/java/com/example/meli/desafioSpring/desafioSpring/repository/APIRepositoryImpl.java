package com.example.meli.desafioSpring.desafioSpring.repository;

import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;
import com.example.meli.desafioSpring.desafioSpring.model.Publications;
import com.example.meli.desafioSpring.desafioSpring.model.Users;
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
    List<Users> dataBase = dataBaseRead();

    @Override
    public void createUser(Users user) {
        if(dataBase.isEmpty())
            throw new DataBaseReadException("Data base is null.");

        dataBase.add(user);

        dataBaseWrite(dataBase);
    }

    @Override
    public Users findById(Integer userId) {
        Users userFound;

        if(dataBase.isEmpty())
            throw new DataBaseReadException("Data base is null.");

        userFound = dataBase.stream().filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        return userFound;
    }

    @Override
    public void setFollower(Users users, Users userToFollow) {
        if(dataBase.isEmpty())
            throw new DataBaseReadException("Data base is null.");

        Users userFiltered = dataBase.stream()
                .filter(user -> user.getUserId().equals(users.getUserId()))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found."));
        Users userToFollowFiltered = dataBase.stream()
                .filter(follower -> follower.getUserId().equals(userToFollow.getUserId()))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        dataBase.remove(userFiltered);
        dataBase.remove(userToFollowFiltered);
        dataBase.add(users);
        dataBase.add(userToFollow);

        dataBaseWrite(dataBase);
    }

    @Override
    public String findUserNameById(Integer userId) {
        Users filteredUser;

        if(dataBase.isEmpty())
            throw new DataBaseReadException("Data base is null.");

        filteredUser = dataBase.stream().filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        return filteredUser.getUserName();
    }

    @Override
    public void createPublication(Integer userId, Publications publication) {
        List<Publications> publicationsList;
        Users filteredUser;

        if(dataBase.isEmpty())
            throw new DataBaseReadException("Data base is null.");

        filteredUser = dataBase.stream().filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        publicationsList = filteredUser.getPublications();
        publicationsList.add(publication);
        filteredUser.setPublications(publicationsList);

        dataBase.remove(filteredUser);
        dataBase.add(filteredUser);

        dataBaseWrite(dataBase);

    }

    @Override
    public List<Publications> getAllPublicationsByUserId(Integer userId) {
        Users filteredUser = findById(userId);

        return filteredUser.getPublications();
    }

    private void dataBaseWrite(List<Users> usersList) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(Paths.get("user.json").toFile(), usersList);
        } catch (IOException e) {
            throw new DataBaseWriteException("Couldnt write to database.");
        }
    }

    private List<Users> dataBaseRead() {
        File file = null;

        try {
            file = ResourceUtils.getFile("/Users/fgusmao/Downloads/desafioSpring/user.json");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Users>> typeRef = new TypeReference<>() { };
        List<Users> usersList = new LinkedList<>();

        try {
            usersList = objectMapper.readValue(file,typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usersList;
    }
}
