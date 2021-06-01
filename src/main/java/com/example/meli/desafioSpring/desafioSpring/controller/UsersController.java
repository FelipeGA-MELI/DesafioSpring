package com.example.meli.desafioSpring.desafioSpring.controller;

import com.example.meli.desafioSpring.desafioSpring.DTO.AllFollowersDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.AllFollowingDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.NumberOfFollowers;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;
import com.example.meli.desafioSpring.desafioSpring.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public void followSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws DataBaseReadException, DataBaseWriteException, UserNotFoundException {
        usersService.followSellerService(userId,userIdToFollow);
    }

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<NumberOfFollowers> getNumberFollowers(@PathVariable Integer userId) throws DataBaseReadException, UserNotFoundException {
        return new ResponseEntity<>(usersService.getNumberFollowersService(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<AllFollowersDTO> getFollowers(@PathVariable Integer userId) throws DataBaseReadException, UserNotFoundException {
        return new ResponseEntity<>(usersService.getFollowersService(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<AllFollowingDTO> getFollowedBy(@PathVariable Integer userId) throws DataBaseReadException, UserNotFoundException {
        return new ResponseEntity<>(usersService.getFollowedByService(userId),HttpStatus.OK);
    }
}
