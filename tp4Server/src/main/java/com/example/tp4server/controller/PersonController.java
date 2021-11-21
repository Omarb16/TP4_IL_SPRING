package com.example.tp4server.controller;

import com.example.tp4server.model.Person;
import com.example.tp4server.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Person")
@CrossOrigin()
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        super();this.personService = personService;
    }

    @PostMapping()
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }

    @GetMapping()
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("find/{id}")
    public Optional<Person> find(@PathVariable("id") int id){
        return personService.find(id);
    }

    @GetMapping("findByNom/{nom}")
    public List<Person> findByNom(@PathVariable("nom") String nom){
        return personService.findByNom(nom);
    }

    @PutMapping()
    public Person update(@RequestBody Person person){
        return personService.update(person);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id){
        personService.delete(id);
    }
}
