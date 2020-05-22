package com.example.demo.controller;

import com.example.demo.assembler.ProductsResourceAssembler;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductsController {

    private final ProductsRepository productsRepository;
    private final ProductsResourceAssembler assembler;


    @GetMapping("/products")
    public ResponseEntity<CollectionModel<EntityModel<Product>>> getProducts() {
        return ResponseEntity.ok(assembler.toCollectionModel(productsRepository.findAll()));
    }


}
