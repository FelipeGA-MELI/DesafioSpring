package com.example.meli.desafioSpring.desafioSpring.controller;

import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    @ResponseStatus(HttpStatus.OK)
    public void followSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws DataBaseReadException {
        usersService.followSellerService(userId,userIdToFollow);
    }
}
