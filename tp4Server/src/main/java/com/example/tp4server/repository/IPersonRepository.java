package com.example.tp4server.repository;

import com.example.tp4server.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByNom(String nom);
}
