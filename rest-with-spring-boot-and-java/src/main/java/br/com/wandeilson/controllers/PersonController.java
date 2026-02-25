package br.com.wandeilson.controllers;

import br.com.wandeilson.data.dto.PersonDTO;
import br.com.wandeilson.models.Person;
import br.com.wandeilson.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll(){
        return service.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO create(@RequestBody PersonDTO person){
        return service.create(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id")Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO update(@RequestBody PersonDTO person){
        return service.update(person);
    }

}
