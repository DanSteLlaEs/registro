package com.DanSteLlaEs.Registro.domain.service;

import com.DanSteLlaEs.Registro.domain.Document;
import com.DanSteLlaEs.Registro.domain.Person;
import com.DanSteLlaEs.Registro.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


public List<Person> getAll(){
    return personRepository.getAll();
}

public Optional<Person> getPerson(int personId){
    return personRepository.getPerson(personId);
}

public Person save(Person person){
    return personRepository.save(person);
}

public boolean delete(int idPerson){
    return getPerson(idPerson).map(document -> {
        personRepository.delete(idPerson);
        return true;
    }).orElse(false);
}
}
