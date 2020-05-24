package com.example.demo.assembler;

import com.example.demo.controller.ProductsController;
import com.example.demo.controller.RootController;
import com.example.demo.entity.Product;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductsResourceAssembler implements SimpleRepresentationModelAssembler<Product> {
    @Override
    public void addLinks(EntityModel<Product> resource) {
        resource.add(
                linkTo(
                        methodOn(ProductsController.class)
                                .getProduct(Objects.requireNonNull(resource.getContent()).getId()))
                        .withSelfRel());
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<Product>> resources) {
        resources.add(linkTo(RootController.class).withSelfRel());
    }
}
