package com.javachallenge.backend.repository;

import com.javachallenge.backend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findById(Integer id);
    List<Person> findAllByNameContainingIgnoreCase(String name);
    void deleteById(Integer id);

}
