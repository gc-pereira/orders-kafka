package edu.example.orders.controller;


import edu.example.orders.models.entity.Person;
import edu.example.orders.models.reposity.PersonRepository;
import edu.example.orders.transfer.PersonData;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    public PersonRepository personRepository;

    @PostMapping
    @Transactional
    public void createPerson(@RequestBody PersonData personData) {
        personRepository.save(
                new Person(
                        personData
                )
        );
    }
}
