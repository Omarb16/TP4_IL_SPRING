package com.example.tp4server.service;

import com.example.tp4server.model.Person;
import com.example.tp4server.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final IPersonRepository personRepository;

    @Autowired
    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person person){
        return personRepository.save(person);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Optional<Person> find(int id){
        return personRepository.findById(id);
    }

    public List<Person> findByNom(String nom){
        return personRepository.findByNom(nom);
    }

    public Person update(Person person){
        return personRepository.save(person);
    }

    public void delete(int id){
        personRepository.deleteById(id);
    }
}
