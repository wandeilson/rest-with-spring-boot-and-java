package br.com.wandeilson.mapper.custom;

import br.com.wandeilson.data.dtov2.PersonDTOV2;
import br.com.wandeilson.models.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person entity){
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setAddress(entity.getAddress());
        dto.setLastName(entity.getLastName());
        dto.setGender(entity.getGender());
        dto.setBirthDay(new Date());
        return dto;
    }

    public Person convertDTOToEntity(PersonDTOV2 dto){
        Person entity = new Person();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setAddress(dto.getAddress());
        entity.setLastName(dto.getLastName());
        entity.setGender(dto.getGender());
        //entity.setBirthDay();
        return entity;
    }
}
