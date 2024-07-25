package com.kmichaylov.exsys.service;

import com.kmichaylov.exsys.dao.PersonDAO;
import com.kmichaylov.exsys.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

/**
 * Class depicting the services for the Person entity.
 */

@Service
public class PersonService {

    private final PersonDAO personDAO;
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * Constructor to initialize the personDAO
     *
     * @param personDAO
     */
    @Autowired
    public PersonService(PersonDAO personDAO, BCryptPasswordEncoder passwordEncoder) {
        this.personDAO = personDAO;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Service to register a person
     *
     * @param person the object of the person
     */
    public void registerPerson(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personDAO.save(person);
        System.out.println("Successfully registered the person");
    }

    /**
     * Service to let an existing person to log-in
     *
     * @param email    the email of the person
     * @param password the password of the user (not hashed)
     * @return the person entity or empty if not registered
     */

    public Optional<Person> login(String email, String password) {
        Person person = personDAO.findByEmail(email);
        if (person != null && passwordEncoder.matches(password, person.getPassword())) {
            return Optional.of(person);
        }

        return Optional.empty();

    }
}
