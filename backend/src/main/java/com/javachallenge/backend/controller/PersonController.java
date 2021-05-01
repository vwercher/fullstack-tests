package com.javachallenge.backend.controller;

import com.javachallenge.backend.model.Person;
import com.javachallenge.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personService.save(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") Integer id, @RequestBody Person person) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personService.update(id, person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable("id") Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personService.getById(id).get());
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll(@RequestParam(value = "name", required = false) String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personService.getAll(name));
    }
}