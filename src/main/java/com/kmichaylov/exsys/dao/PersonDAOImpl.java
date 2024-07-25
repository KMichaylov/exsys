package com.kmichaylov.exsys.dao;

import com.kmichaylov.exsys.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of the PersonDAO interface using JPA EntityManager.
 * Provides CRUD operations for Person entities.
 */
@Repository
public class PersonDAOImpl implements PersonDAO {

    private EntityManager entityManager;

    /**
     * Constructor for the PersonDAOImpl.
     *
     * @param entityManager the JPA EntityManager to use
     */
    @Autowired
    public PersonDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Saves a new person entity.
     *
     * @param person the person entity to save
     */
    @Override
    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    /**
     * Saves a collection of people.
     *
     * @param people the array of entities to save
     */

    public void saveAll(List<Person> people) {
        people.forEach(entityManager::persist);
    }

    /**
     * Finds a person entity by its id.
     *
     * @param person_id the person_id of the person to find
     * @return the found person entity, or null if not found
     */
    @Override
    @Transactional
    public Person findById(String person_id) {
        return entityManager.find(Person.class, person_id);
    }

    /**
     * Retrieves all person entities.
     *
     * @return a list of all person entities
     */
    @Override
    public List<Person> findAll() {
        TypedQuery<Person> query = entityManager.createQuery("FROM Person", Person.class);
        return query.getResultList();
    }

    /**
     * Finds person entities by their full name.
     *
     * @param fullName the full name to search for
     * @return a list of person entities with the given full name
     */
    @Override
    public List<Person> findByFullName(String fullName) {
        TypedQuery<Person> query = entityManager.createQuery("FROM Person WHERE fullName=:fullName", Person.class);
        query.setParameter("fullName", fullName);
        return query.getResultList();
    }

    /**
     * Updates an existing person entity.
     *
     * @param person the person entity to update
     */
    @Override
    @Transactional
    public void update(Person person) {
        entityManager.merge(person);
    }

    /**
     * Deletes a person entity by its ID.
     *
     * @param person_id the ID of the person to delete
     */
    @Override
    @Transactional
    public void delete(String person_id) {
        Person person = entityManager.find(Person.class, person_id);
        if (person != null) {
            entityManager.remove(person);
        }
    }

    /**
     * Deletes all person entities.
     *
     * @return the number of entities deleted
     */
    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Person").executeUpdate();
    }
}
