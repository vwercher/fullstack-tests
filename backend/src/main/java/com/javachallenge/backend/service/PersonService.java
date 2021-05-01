package com.javachallenge.backend.service;

import com.javachallenge.backend.model.Person;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PersonService {
    Person create(Person person);
    Person getById(Integer id);
    List<Person> getAll(String name);
}
