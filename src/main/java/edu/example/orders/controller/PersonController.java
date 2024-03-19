package edu.example.orders.controller;


import edu.example.orders.models.entity.Person;
import edu.example.orders.models.reposity.PersonRepository;
import edu.example.orders.transfer.PersonData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    public PersonRepository personRepository;

    @PostMapping
    @Transactional
    public void createPerson(@RequestBody @Valid PersonData personData) {
        personRepository.save(
                new Person(
                        personData
                )
        );
    }

    @GetMapping
    public @ResponseBody Optional<Person> getPerson(@RequestParam(name = "id") Long id) {
        return personRepository.findById(id);
    }

    @GetMapping(value = "/id")
    public @ResponseBody List<Person> getAllPerson() {
        return personRepository.findAll();
    }
}
