package br.com.wandeilson.services;

import br.com.wandeilson.data.dtov1.PersonDTO;
import br.com.wandeilson.data.dtov2.PersonDTOV2;
import br.com.wandeilson.exceptions.ResourceNotFoundException;
import br.com.wandeilson.mapper.custom.PersonMapper;
import br.com.wandeilson.models.Person;
import br.com.wandeilson.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static br.com.wandeilson.mapper.ObjectMapper.parseListObjects;
import static br.com.wandeilson.mapper.ObjectMapper.parseObject;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository repository;
    @Autowired
    private PersonMapper converter;

    public List<PersonDTO> findAll(){
        logger.info("Finding all People.");

        return parseListObjects(repository.findAll(),PersonDTO.class);
    }

    public PersonDTO findById(Long id){
        logger.info("Finding one Person.");

        Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO findByIdv2(Long id){
        logger.info("Finding one Person.");

        Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create (PersonDTO dto){
        logger.info("Creating one Person.");

        Person entity = parseObject(dto,Person.class);

        return parseObject(repository.save(entity),PersonDTO.class);

    }

    public PersonDTOV2 createV2 (PersonDTOV2 dto){
        logger.info("Creating one Person V2");

        Person entity = converter.convertDTOToEntity(dto);

        return converter.convertEntityToDTO(repository.save(entity));

    }

    public PersonDTO update (PersonDTO dto){
        logger.info("Updating one Person.");
        Person entity = repository.findById(dto.getId())
                .orElseThrow(()-> new ResourceNotFoundException("No records found for thid ID"));


        return parseObject(repository.save(parseObject(dto,Person.class)),PersonDTO.class);

    }

    public void delete (Long id){
        logger.info("Deleting one Person.");

        Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for thid ID"));

        repository.delete(entity);
    }

}
