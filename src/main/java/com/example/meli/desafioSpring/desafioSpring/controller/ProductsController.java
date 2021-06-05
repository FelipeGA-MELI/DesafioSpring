package com.example.meli.desafioSpring.desafioSpring.controller;

import com.example.meli.desafioSpring.desafioSpring.DTO.AllPromoPublicationsDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.NumberOfPublicationsDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationWithUserIdDTO;
import com.example.meli.desafioSpring.desafioSpring.DTO.PublicationsByUserDTO;
import com.example.meli.desafioSpring.desafioSpring.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;
    private static final String DEFAULT_ORDER = "date_asc";

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/newpost")
    @ResponseStatus(HttpStatus.OK)
    public void createPublication(@RequestBody PublicationWithUserIdDTO publicationWithUserIdDTO) {
        productsService.createPublicationService(publicationWithUserIdDTO, false);
    }

    @PostMapping("/newpromopost")
    @ResponseStatus(HttpStatus.OK)
    public void createPromoPublication(@RequestBody PublicationWithUserIdDTO publicationWithUserIdDTO) {
        productsService.createPublicationService(publicationWithUserIdDTO, true);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PublicationsByUserDTO> getPublicationsByUser(@PathVariable Integer userId, @RequestParam(defaultValue = DEFAULT_ORDER) String order) {
        return new ResponseEntity<>(productsService.getPublicationsByUserService(userId,order),HttpStatus.OK);
    }

    @GetMapping("{userId}/countPromo/")
    public ResponseEntity<NumberOfPublicationsDTO> getNumberOfPublications(@PathVariable Integer userId) {
        return new ResponseEntity<>(productsService.getNumberPublications(userId),HttpStatus.OK);
    }

    @GetMapping("{userId}/list")
    public ResponseEntity<AllPromoPublicationsDTO> getAllPromoPublications(@PathVariable Integer userId) {
        return new ResponseEntity<>(productsService.getPromoPublications(userId),HttpStatus.OK);
    }
}
