package com.example.demo.controller;

import com.example.demo.assembler.CarResourceAssembler;
import com.example.demo.entity.Car;
import com.example.demo.errors.CarNotFoundException;
import com.example.demo.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CarController {

  private final CarRepository carRepository;
  private final CarResourceAssembler assembler;

  @GetMapping
  public RepresentationModel<?> root() {

    RepresentationModel<?> rootResource = new RepresentationModel<>();

    rootResource.add( //
                      linkTo(methodOn(CarController.class).root()).withSelfRel(), //
                      linkTo(methodOn(CarController.class).getCars()).withRel("cars"));

    return rootResource;
  }

  @GetMapping("/cars")
  public ResponseEntity<CollectionModel<EntityModel<Car>>> getCars() {
    return ResponseEntity
            .ok(assembler.toCollectionModel(carRepository.findAll()));
  }

  @GetMapping("/cars/{id}")
  public ResponseEntity<EntityModel<Car>> getCar(@PathVariable Long id) {
    return carRepository
        .findById(id)
        .map(assembler::toModel)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new CarNotFoundException(id));
  }

  @PostMapping("/cars")
  public ResponseEntity<EntityModel<Car>> addCar(@RequestBody Car car) {
    Car savedCar = carRepository.save(Objects.requireNonNull(car));
    return ResponseEntity
            .created(linkTo(methodOn(CarController.class)
                             .getCar(car.getId()))
                             .toUri())
            .body(assembler.toModel(savedCar));
  }

  @DeleteMapping("/cars/{id}")
  public ResponseEntity<?> deleteCar(@PathVariable Long id) {
    carRepository.deleteById(id);
    return ResponseEntity.ok("ID " + id + " deleted");
  }
}
