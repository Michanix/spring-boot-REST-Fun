package com.example.demo.assembler;

import com.example.demo.entity.Product;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;


@Component
public class ProductsResourceAssembler implements SimpleRepresentationModelAssembler<Product> {
    @Override
    public void addLinks(EntityModel<Product> resource) {
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<Product>> resources) {

    }
}
