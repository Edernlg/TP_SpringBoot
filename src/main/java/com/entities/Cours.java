package com.entities;

import javax.persistence.*;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Cours {

    // jointure de cours à creneau
    @OneToMany(mappedBy = "cours")
    private Set<Creneau> crenaux;

    // Déclarations des variables de la table cours
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String intitule;
}
