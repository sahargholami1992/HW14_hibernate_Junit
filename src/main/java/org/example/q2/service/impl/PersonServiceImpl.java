package org.example.q2.service.impl;

import org.example.q2.entity.Person;
import org.example.q2.repository.PersonRepository;
import org.example.q2.service.PersonService;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;

public class PersonServiceImpl<T extends Person , R extends PersonRepository<T>> implements PersonService<T> {
    R personRepository;


    public PersonServiceImpl(R personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person signUp(String firstName, String lastName) {
        if (!personRepository.contains(firstName,lastName)){
            Person person = new Person();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            personRepository.save((T) person);
            return person;
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        personRepository.delete(id);
    }

    @Override
    public void update(T person, Integer id) {
        personRepository.update(person,id);
    }

    @Override
    public List<T> loadAll() {
        return personRepository.loadAll();
    }

    @Override
    public boolean contains(String firstName, String lastName) {
        return personRepository.contains(firstName, lastName);
    }

    @Override
    public T findById(Integer id) {
        return personRepository.findById(id);
    }
}
