package com.example.service;


import com.example.model.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public boolean deletePersonById(int id) {
        return persons.removeIf(person -> person.getId() == id);
    }

    public Person searchPersonById(int id) {
        return persons.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(persons);
    }
}
