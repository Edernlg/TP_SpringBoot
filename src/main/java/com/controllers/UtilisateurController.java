package com.controllers;

import com.dtos.UtilisateurDto;
import com.services.impl.UtilisateurServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Utilisateur")
public class UtilisateurController {
    private final UtilisateurServiceImpl utilisateurService;

    public UtilisateurController(UtilisateurServiceImpl utilisateurServiceService) {
        this.utilisateurService = utilisateurServiceService;
    }

    /**
     * <p>Get all Utilisateurs in the system</p>
     * @return List<UtilisateurDto>
     */
    @GetMapping
    public List<UtilisateurDto> getUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    /**
     * Method to get the Utilisateur based on the ID
     */
    @GetMapping("/{id}")
    public UtilisateurDto getutilisateur(@PathVariable Long id){
        return utilisateurService.getUtilisateurById(id);
    }

    /**
     * Create a new Utilisateur in the system
     */
    @PostMapping
    public UtilisateurDto saveUtilisateur(final @RequestBody UtilisateurDto utilisateurDto){
        return utilisateurService.saveUtilisateur(utilisateurDto);
    }

    /**
     * Delete a Utilisateur by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteUtilisateur(@PathVariable Long id){
        return utilisateurService.deleteUtilisateur(id);
    }

}



