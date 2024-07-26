package com.kmichaylov.exsys.controller;

import com.kmichaylov.exsys.dto.LoginDTO;
import com.kmichaylov.exsys.dto.RegistrationDTO;
import com.kmichaylov.exsys.enumeration.Role;
import com.kmichaylov.exsys.exception.PersonNotFoundException;
import com.kmichaylov.exsys.model.Person;
import com.kmichaylov.exsys.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/register")
    public ResponseEntity<Person> register(@RequestBody RegistrationDTO registrationDTO) {

        Person registeredPerson = personService.registerPerson(registrationDTO);
        return ResponseEntity.ok(registeredPerson);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        Optional<Person> person = personService.login(loginDTO);
        if (person.isPresent()) {
            return ResponseEntity.ok("Successful Login!");
        }
        throw new PersonNotFoundException("Student not found. Check your email and password. First register if you don't have an account!");
    }


}
