package com.example.test_technique.mapper;

import com.example.test_technique.bean.Personne;
import com.example.test_technique.dto.PersonneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public class PersonneMapper {

    public Personne toEntity(PersonneDTO personneDTO){
        Personne personne = new Personne();

        personne.setPrenom(personneDTO.getPrenom());
        personne.setNom(personneDTO.getNom());
        personne.setDateNaissance(personneDTO.getDateNaissance());
        personne.setId(UUID.randomUUID());

        return personne;
    }
}
