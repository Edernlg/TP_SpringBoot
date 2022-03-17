package com.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data

public class Creneau {
    @ManyToOne
    private Cours cours;

    // Déclarations des variables de la table Créneau
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDate date_heure;
    private long duree;
    private String type;
}
