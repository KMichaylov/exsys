package com.kmichaylov.exsys.repository;

import com.kmichaylov.exsys.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {


    /**
     * Finds person entities by their full name.
     *
     * @param fullName the full name to search for
     * @return a list of person entities with the given full name
     */
    List<Person> findByFullName(String fullName);


    /**
     * Finds person entities by their full name.
     *
     * @param email of the person
     * @return the person entity with the given email
     */
    Optional<Person> findByEmail(String email);
}
