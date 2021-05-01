package com.javachallenge.backend.service;

import com.javachallenge.backend.model.Person;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface PersonService {
    Person save(Person person);
    Person update(Integer id, Person person);
    Person delete(Integer id);
    Optional<Person> getById(Integer id);
    List<Person> getAll(String name);
}
