package com.example.test_technique.service;

import com.example.test_technique.bean.Personne;
import com.example.test_technique.repository.PersonneRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonneService {

    private final PersonneRepository personneRepository;
    public Personne creer(final Personne personne) throws Exception {
        if (calculerAge(personne.getDateNaissance()) < 150){
            System.out.println("Création de " + personne.getNom() + " agé de " + personne.getPrenom() + " ans.");
            return this.personneRepository.saveAndFlush(personne);
        } else {
            System.out.println("La personne " + personne.getNom() + " a plus de 150ans, elle ne sera pas enregistrée");
            throw new Exception(String.valueOf(HttpStatus.BAD_REQUEST));
        }
    }

    public List<Personne> obtenirListePersonne(){
        List<Personne> listePersonne= this.personneRepository.findAll();

        listePersonne.stream().sorted(Comparator.comparing(Personne::getNom).thenComparing(Personne::getPrenom)).collect(Collectors.toList());

        return listePersonne;
    }


    private int calculerAge(LocalDate dateNaissance) {
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }

}
