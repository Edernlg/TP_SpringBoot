package com.dtos;

import com.entities.Cours;
import com.entities.SeanceFormation;

import java.util.List;
import lombok.Data;

@Data

public class VacataireDto {

    private List<SeanceFormation> effectue;
    private Cours participe;
}
