package com.example.demo.controller;

import com.example.demo.assembler.AccountResourceAssembler;
import com.example.demo.customJson.CustomJSONResponse;
import com.example.demo.entity.Account;
import com.example.demo.errors.AccountNotFoundException;
import com.example.demo.repository.AccountRepository;
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
@RequestMapping("/accounts")
public class AccountController {

  private final AccountRepository repository;
  private final AccountResourceAssembler assembler;

  @GetMapping
  public ResponseEntity<CollectionModel<EntityModel<Account>>> getAccounts() {
    return ResponseEntity.ok(assembler.toCollectionModel(repository.findAll()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<EntityModel<Account>> getAccount(@PathVariable Long id) {
    return repository
            .findById(id)
            .map(assembler::toModel)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new AccountNotFoundException(id));
  }

  @PostMapping
  public ResponseEntity<EntityModel<Account>> addAccount(@RequestBody Account account) {
    var savedProduct = repository.save(Objects.requireNonNull(account));
    return ResponseEntity.created(linkTo(ProductsController.class).withSelfRel().toUri())
            .body(assembler.toModel(savedProduct));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
      return new ResponseEntity<>(
              new CustomJSONResponse(
                      String.valueOf(HttpStatus.ACCEPTED.value()),
                      HttpStatus.ACCEPTED.getReasonPhrase(),
                      "Account with id " + id + " has been deleted."),
              HttpStatus.ACCEPTED);
    } else {
      throw new AccountNotFoundException(id);
    }
  }
}
