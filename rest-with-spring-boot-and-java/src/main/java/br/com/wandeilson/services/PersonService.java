package br.com.wandeilson.services;

import br.com.wandeilson.exceptions.ResourceNotFoundException;
import br.com.wandeilson.models.Person;
import br.com.wandeilson.repository.PersonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll(){
        logger.info("Finding all People.");

        return repository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one Person.");

        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for thid ID"));
    }

    public Person create (Person person){
        logger.info("Creating one Person.");
        return repository.save(person);
    }

    public Person update (Person person){
        logger.info("Updating one Person.");
        Person entity = repository.findById(person.getId())
                .orElseThrow(()-> new ResourceNotFoundException("No records found for thid ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete (Long id){
        logger.info("Deleting one Person.");

        Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for thid ID"));

        repository.delete(entity);
    }

}
