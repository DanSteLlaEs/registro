package com.DanSteLlaEs.Registro.domain.repository;

import com.DanSteLlaEs.Registro.domain.Document;
import com.DanSteLlaEs.Registro.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    List<Person> getAll();
    Optional<Person> getPerson(int idPerson);
    Person save(Person person);
    void delete(int idPerson);
}
