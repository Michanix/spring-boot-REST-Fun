package com.example.demo.assembler;

import com.example.demo.controller.AccountController;
import com.example.demo.controller.RootController;
import com.example.demo.entity.Account;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AccountResourceAssembler implements SimpleRepresentationModelAssembler<Account> {
  @Override
  public void addLinks(EntityModel<Account> resource) {
    resource.add(
            linkTo(
                    methodOn(AccountController.class)
                            .getAccount(Objects.requireNonNull(resource.getContent()).getId()))
                    .withSelfRel());
  }

  @Override
  public void addLinks(CollectionModel<EntityModel<Account>> resources) {
    resources.add(linkTo(RootController.class).withSelfRel());
  }
}
