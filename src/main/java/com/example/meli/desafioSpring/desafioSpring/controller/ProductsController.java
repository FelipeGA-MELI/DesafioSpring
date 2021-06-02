package com.example.meli.desafioSpring.desafioSpring.controller;

import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationWithUserIdDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationsByUserDTO;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseReadException;
import com.example.meli.desafioSpring.desafioSpring.exception.DataBaseWriteException;
import com.example.meli.desafioSpring.desafioSpring.exception.UserNotFoundException;
import com.example.meli.desafioSpring.desafioSpring.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/newpost")
    @ResponseStatus(HttpStatus.OK)
    public void createPublication(@RequestBody PublicationWithUserIdDTO publicationWithUserIdDTO) throws DataBaseReadException, DataBaseWriteException, UserNotFoundException {
        productsService.createPublicationService(publicationWithUserIdDTO);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PublicationsByUserDTO> getPublicationsByUser(@PathVariable Integer userId) throws DataBaseReadException, UserNotFoundException {
        return new ResponseEntity<>(productsService.getPublicationsByUserService(userId),HttpStatus.OK);
    }
}
