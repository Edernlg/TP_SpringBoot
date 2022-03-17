package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Vacataire extends Utilisateur{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // jointure de Vacataire à Seance_Formation
    @OneToMany
    private List<SeanceFormation> effectue;

    // jointure de Vacataire à Cours
    @ManyToOne
    private Cours participe;
}
