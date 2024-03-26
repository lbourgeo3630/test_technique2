package com.example.test_technique.service;

import com.example.test_technique.bean.Personne;
import com.example.test_technique.repository.PersonneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonneService {

    private final PersonneRepository personneRepository;
    public Personne creer(final Personne personne) {
        System.out.println("Création " + personne.getNom() + " agé de " + personne.getPrenom() + " ans.");
        return this.personneRepository.saveAndFlush(personne);
    }

}
