package com.javachallenge.backend.service.impl;

import com.javachallenge.backend.adapter.GenderAdapter;
import com.javachallenge.backend.exception.CommonException;
import com.javachallenge.backend.model.Person;
import com.javachallenge.backend.repository.PersonRepository;
import com.javachallenge.backend.service.PersonService;
import com.javachallenge.backend.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private ValidateUtil validateUtil;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GenderAdapter genderAdapter;

    public Person save(Person person) throws CommonException {
        this.validateUtil.validatePersonData(person);
        return this.personRepository.save(person);
    }

    public Person update(Integer id, Person person) throws CommonException {
        this.validateUtil.validatePersonData(person);
        person.setId(id);
        return this.personRepository.save(person);
    }

    public Boolean delete(Integer id) {
        this.personRepository.deleteById(id);
        return Boolean.TRUE;
    }

    public Optional<Person> getById(Integer id) {
        return personRepository.findById(id);
    }

    public List<Person> getAll(String name) {
        List<Person> persons;
        if (name != null && !name.isEmpty()) {
            persons = this.personRepository.findAllByNameContainingIgnoreCase(name);
        } else {
            persons = this.personRepository.findAll();
        }
        this.genderAdapter.convertGenderIdentifierToDescription(persons);
        return persons;
    }
}
