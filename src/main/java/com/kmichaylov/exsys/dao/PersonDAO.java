package com.kmichaylov.exsys.dao;

import com.kmichaylov.exsys.model.Person;

import java.util.List;

public interface PersonDAO {

    void save(Person person);

    Person findById(int id);

    List<Person> findAll();

    List<Person> findByFullName(String fullName);

    void update(Person person);

    void delete(Integer id);

    int deleteAll();
}
