package com.example.meli.desafioSpring.desafioSpring.controller;

import com.example.meli.desafioSpring.desafioSpring.DTO.AllFollowersDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.AllFollowingDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.NumberOfFollowersDTO;
import com.example.meli.desafioSpring.desafioSpring.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;
    private final static String DEFAULT_ORDER = "name_asc";

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    @ResponseStatus(HttpStatus.OK)
    public void followSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        usersService.followSellerService(userId,userIdToFollow);
    }

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<NumberOfFollowersDTO> getNumberOfFollowers(@PathVariable Integer userId) {
        return new ResponseEntity<>(usersService.getNumberFollowersService(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<AllFollowersDTO> getFollowers(@PathVariable Integer userId, @RequestParam(defaultValue = DEFAULT_ORDER) String order) {
        return new ResponseEntity<>(usersService.getFollowersService(userId,order),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<AllFollowingDTO> getFollowedBy(@PathVariable Integer userId, @RequestParam(defaultValue = DEFAULT_ORDER) String order) {
        return new ResponseEntity<>(usersService.getFollowedByService(userId,order),HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    @ResponseStatus(HttpStatus.OK)
    public void UnfollowSeller(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        usersService.unfollowSellerService(userId,userIdToUnfollow);
    }
}
