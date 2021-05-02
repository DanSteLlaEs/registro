package com.DanSteLlaEs.Registro.web.controller;

import com.DanSteLlaEs.Registro.domain.Document;
import com.DanSteLlaEs.Registro.domain.Person;
import com.DanSteLlaEs.Registro.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {


    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersons(@PathVariable("id") int idPerson){
        return personService.getPerson(idPerson)
                .map(person -> new ResponseEntity<>(person,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Person> save(@RequestBody Person person){
        return new ResponseEntity<>(personService.save(person) ,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int idPerson){
        if (personService.delete(idPerson)) {
            return  new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> update (@RequestBody Person personDetails,@PathVariable("id") int idPerson) {
        Optional<Person> person = personService.getPerson(idPerson);

        if (!person.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        person.get().setTypePerson(personDetails.getTypePerson());
        person.get().setFistSurname(personDetails.getFistSurname());
        person.get().setSecondSurname(personDetails.getSecondSurname());
        person.get().setFistName(personDetails.getFistName());
        person.get().setSecondsName(personDetails.getSecondsName());
        person.get().setNit(personDetails.getNit());
        person.get().setDv(personDetails.getDv());
        person.get().setTypeDocument(personDetails.getTypeDocument());
        person.get().setNumberDocument(personDetails.getNumberDocument());
        person.get().setDateExpedition(personDetails.getDateExpedition());
        person.get().setPlaceExpedition(personDetails.getPlaceExpedition());
        person.get().setCountry(personDetails.getCountry());
        person.get().setDpto(personDetails.getDpto());
        person.get().setCity(personDetails.getCity());
        person.get().setAddress(personDetails.getAddress());
        person.get().setLandline(personDetails.getLandline());
        person.get().setPhone(personDetails.getPhone());
        person.get().setBusinessName(personDetails.getBusinessName());
        person.get().setPosition(personDetails.getPosition());

        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person.get()));

    }


}
