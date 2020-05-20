package com.example.demo.assembler;

import com.example.demo.controller.CarController;
import com.example.demo.entity.Car;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CarResourceAssembler implements SimpleRepresentationModelAssembler<Car> {

  public CarResourceAssembler() {}

  @Override
  public void addLinks(EntityModel<Car> resource) {
    resource.add(
        linkTo(methodOn(CarController.class)
                       .getCar(Objects.requireNonNull(resource.getContent()).getId()))
            .withSelfRel());
  }

  @Override
  public void addLinks(CollectionModel<EntityModel<Car>> resources) { }
}
