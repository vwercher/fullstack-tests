package com.javachallenge.backend.service.impl;

import com.javachallenge.backend.model.Person;
import com.javachallenge.backend.repository.PersonRepository;
import com.javachallenge.backend.service.PersonService;
import com.javachallenge.backend.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private ValidateUtil validateUtil;

    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person) {
        this.validateUtil.validateSavePerson(person);
        return this.personRepository.save(person);
    }

    public Person update(Integer id, Person person) {
        return new Person();
    }

    public Person delete(Integer id) {
        return new Person();
    }

    public Optional<Person> getById(Integer id) {
        return personRepository.findById(id);
    }

    public List<Person> getAll(String name) {
        return new ArrayList<>();
    }
}
