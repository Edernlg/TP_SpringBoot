package com.services;

import com.dtos.VacataireDto;

import java.util.List;

public interface VacataireService {
    /**
     * Save Vacataire
     */
    VacataireDto saveVacataire(VacataireDto vacataireDto);

    /**
     * Get a vacataire by id
     */
    VacataireDto getVacataireById(Long vacataireDtoId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteVacataire(Long VacataireId);

    /**
     * Get all the Vacataire
     */
    List<VacataireDto> getAllVacataire();
}
