package com.example.test_technique.mapper;

import com.example.test_technique.bean.Personne;
import com.example.test_technique.dto.PersonneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public class PersonneMapper {

    public Personne toEntity(PersonneDTO personneDTO){
        Personne personne = new Personne();

        personne.setAge(personneDTO.getAge());
        personne.setName(personneDTO.getName());

        return personne;
    }
}
