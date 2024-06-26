package com.example.test_technique.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonneDTO {

    private String nom;

    private String prenom;

    private LocalDate dateNaissance;

}
