package com.services;

import com.dtos.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    /**
     * Save Utilisateur
     */
    UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto);

    /**
     * Get a Utilisateur by id
     */
    UtilisateurDto getUtilisateurById(Long utilisateurDtoId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteUtilisateur(Long utilisateurId);

    /**
     * Get all the Utilisateur
     */
    List<UtilisateurDto> getAllUtilisateur();
}
