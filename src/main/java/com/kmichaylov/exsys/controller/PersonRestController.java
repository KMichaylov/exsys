package com.kmichaylov.exsys.controller;

import com.kmichaylov.exsys.dto.LoginDTO;
import com.kmichaylov.exsys.dto.RegistrationDTO;
import com.kmichaylov.exsys.enumeration.Role;
import com.kmichaylov.exsys.model.Person;
import com.kmichaylov.exsys.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonRestController {

    private PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegistrationDTO registrationDTO) {
        Person person = new Person();
        person.setFullName(registrationDTO.getFullName());
        person.setEmail(registrationDTO.getEmail());
        person.setPassword(registrationDTO.getPassword());
        person.setRole(Role.STUDENT);
        personService.registerPerson(person);
       return "Successful registration of person";

    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        Optional<Person> person = personService.login(loginDTO.getEmail(), loginDTO.getPassword());
        if (person.isPresent()) {
            return "Login successful";
        }
        return "Invalid credentials";
    }


}
