package com.example.demo.controller;

import com.example.demo.assembler.ProductsResourceAssembler;
import com.example.demo.customJson.CustomJSONResponse;
import com.example.demo.entity.Product;
import com.example.demo.errors.ProductNotFoundException;
import com.example.demo.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

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

  @GetMapping("/products/{id}")
  public ResponseEntity<EntityModel<Product>> getProduct(@PathVariable Long id) {
    return productsRepository
            .findById(id)
            .map(assembler::toModel)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new ProductNotFoundException(id));
  }

  @PostMapping("/products")
  public ResponseEntity<EntityModel<Product>> addProduct(@RequestBody Product product) {
    var savedProduct = productsRepository.save(Objects.requireNonNull(product));
    return ResponseEntity.created(linkTo(ProductsController.class).withSelfRel().toUri())
            .body(assembler.toModel(savedProduct));
  }

  @DeleteMapping("/products/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
    if (productsRepository.existsById(id)) {
      productsRepository.deleteById(id);
      return new ResponseEntity<>(
              new CustomJSONResponse(
                      String.valueOf(HttpStatus.ACCEPTED.value()),
                      HttpStatus.ACCEPTED.getReasonPhrase(),
                      "Product with id " + id + " has been deleted."),
              HttpStatus.ACCEPTED);
    } else {
      throw new ProductNotFoundException(id);
    }
  }
}
