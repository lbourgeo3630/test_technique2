package com.example.test_technique.controleur;

import com.example.test_technique.bean.Personne;
import com.example.test_technique.dto.PersonneDTO;
import com.example.test_technique.mapper.PersonneMapper;
import com.example.test_technique.service.PersonneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class PersonneControleur {

    private final PersonneService testService;
    private final PersonneMapper personneMapper;

    @GetMapping
    public ResponseEntity<String> getTest() {
        System.out.println("Appel methode get");
        return ResponseEntity.status(HttpStatus.FOUND).body("Hello world");
    }

    /**
     * Methode qui permet d'enregistrer une personne
     *
     * @param name
     * @param age
     * @return
     */
    @PostMapping
    public ResponseEntity<Personne> postTest(@RequestParam(name = "nom") String nom,
                                             @RequestParam(name = "prenom") String prenom,
                                             @RequestParam(name = "dateNaissance") Date dateNaissance){
        System.out.println("Appel methode post");

        Personne personneAEnregistrer = personneMapper.toEntity(PersonneDTO.builder()
                .prenom(prenom)
                .nom(nom)
                .dateNaissance(dateNaissance)
                .build());
        Personne personneRetournee = testService.creer(personneAEnregistrer);
        return ResponseEntity.status(HttpStatus.CREATED).body(personneRetournee);
    }
}
