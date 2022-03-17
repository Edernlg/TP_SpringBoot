package com.dtos;

import com.entities.Cours;
import com.entities.Creneau;
import com.entities.SeanceFormation;

import java.util.List;
import java.util.Set;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data

public class CoursDto {

    private Set<Creneau> crenaux;

    // Déclarations des variables de la table cours
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String intitule;
}
