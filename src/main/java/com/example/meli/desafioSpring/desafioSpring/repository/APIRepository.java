package com.example.meli.desafioSpring.desafioSpring.repository;
import com.example.meli.desafioSpring.desafioSpring.model.Publications;
import com.example.meli.desafioSpring.desafioSpring.model.Users;

import java.util.List;

public interface APIRepository {
    Users findById(Integer userId);

    void setFollower(Users users, Users userToFollow);

    String findUserNameById(Integer userId);

    void createPublication(Integer userId, Publications publication);

    List<Publications> getAllPublicationsByUserId(Integer userId);
}
