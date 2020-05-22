package com.example.demo.controller;

import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@NoArgsConstructor
@RequestMapping("/api")
public class RootController {

    @GetMapping
    ResponseEntity<RepresentationModel<?>> root() {

        var model = new RepresentationModel<>();

        model.add(linkTo(methodOn(RootController.class).root()).withSelfRel());
        model.add(linkTo(methodOn(CarController.class).getCars()).withRel("cars"));
        model.add(linkTo(methodOn(ProductsController.class).getProducts()).withRel("products"));

        return ResponseEntity.ok(model);
    }
}
