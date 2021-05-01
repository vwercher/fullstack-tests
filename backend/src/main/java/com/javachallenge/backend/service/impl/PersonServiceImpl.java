package com.javachallenge.backend.service.impl;

import com.javachallenge.backend.model.Person;
import com.javachallenge.backend.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    public Person create(Person person) {
        return new Person();
    }

    public Person getById(Integer id) {
        return new Person();
    }

    public List<Person> getAll(String name) {
        return new ArrayList<>();
    }
}
