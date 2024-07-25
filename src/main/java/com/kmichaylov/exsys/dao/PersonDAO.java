package com.kmichaylov.exsys.dao;

import com.kmichaylov.exsys.model.Person;

import java.util.List;

/**
 * Interface for Data Access Object (DAO) to manage Person entities.
 * Defines methods for CRUD operations.
 */
public interface PersonDAO {

    /**
     * Saves a new person entity.
     *
     * @param person the person entity to save
     */
    void save(Person person);

    /**
     * Finds a person entity by its ID.
     *
     * @param id the ID of the person to find
     * @return the found person entity, or null if not found
     */
    Person findById(String id);

    /**
     * Retrieves all person entities.
     *
     * @return a list of all person entities
     */
    List<Person> findAll();

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
    Person findByEmail(String email);

    /**
     * Updates an existing person entity.
     *
     * @param person the person entity to update
     */
    void update(Person person);

    /**
     * Deletes a person entity by its ID.
     *
     * @param id the ID of the person to delete
     */
    void delete(String id);

    /**
     * Deletes all person entities.
     *
     * @return the number of entities deleted
     */
    int deleteAll();
}
