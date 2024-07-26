package com.kmichaylov.exsys.service;

import com.kmichaylov.exsys.dao.PersonDAO;
import com.kmichaylov.exsys.dto.LoginDTO;
import com.kmichaylov.exsys.dto.RegistrationDTO;
import com.kmichaylov.exsys.enumeration.Role;
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
     * @param registrationDTO the dto object of the person to be registered
     * @return the created person object from the dto
     */
    public Person registerPerson(RegistrationDTO registrationDTO) {
        Person person = new Person();
        person.setFullName(registrationDTO.getFullName());
        person.setEmail(registrationDTO.getEmail());
        person.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        person.setRole(Role.STUDENT);

        personDAO.save(person);
        System.out.println("Successfully registered the person");
        return person;
    }

    /**
     * Service to let an existing person to log-in
     *
     * @param loginDTO the dto containing login details
     * @return the person entity or empty if not registered
     */

    public Optional<Person> login(LoginDTO loginDTO) {
        String email = loginDTO.getEmail();
        String passwordInput = loginDTO.getPassword();
        String passwordFromDB = personDAO.findByEmail(email).getPassword();
        Person person = personDAO.findByEmail(email);
        System.out.println(passwordInput);
        System.out.println(passwordFromDB);
        System.out.println(email);
        if (!email.isEmpty() && passwordEncoder.matches(passwordInput, passwordFromDB)) {
            return Optional.of(person);
        }

        return Optional.empty();

    }
}
