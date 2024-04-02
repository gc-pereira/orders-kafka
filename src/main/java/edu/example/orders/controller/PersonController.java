package edu.example.orders.controller;


import edu.example.orders.message.ProducerMessage;
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

    ProducerMessage producerMessage;

    @PostMapping
    @Transactional
    public void createPerson(@RequestBody @Valid PersonData personData) {
        personRepository.save(
                new Person(
                        personData
                )
        );
        producerMessage.setTopicName("PERSON");
        producerMessage.setHeader("CREATE_PERSON");
        producerMessage.sendMessage(personData.toString());
    }

    @GetMapping
    public @ResponseBody Optional<Person> getPerson(@RequestParam(name = "id") Long id) {
        return personRepository.findById(id);
    }

    @GetMapping(value = "/id")
    public @ResponseBody List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @DeleteMapping(value = "/id")
    public void deletePerson(@RequestParam(name = "id") Long id){
        personRepository.deleteById(id);
        producerMessage.setTopicName("PERSON");
        producerMessage.setHeader("DELETE_PERSON");
        producerMessage.sendMessage(personRepository.findById(id).toString());
    }
}
