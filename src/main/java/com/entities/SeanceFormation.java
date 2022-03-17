package com.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class SeanceFormation {

    // joiture de Seance_formation à Creneau
    @ManyToOne
    private Creneau planifie;

    // Déclaration des variables seance_formation
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private boolean estEffectue;
    private long dureeEffectue;
    private boolean valide;
    private String commentaire;


}
