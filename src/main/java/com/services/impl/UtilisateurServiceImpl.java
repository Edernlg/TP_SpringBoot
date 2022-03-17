package com.services.impl;

import com.dtos.UtilisateurDto;
import com.entities.Utilisateur;
import com.repositories.UtilisateurRepository;
import com.services.UtilisateurService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("utilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService{

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto) {
        // Converts the dto to the Utilisateur entity
        Utilisateur utilisateur = UtilisateurDtoToEntity(utilisateurDto);
        // Save the Utilisateur entity
        utilisateur = utilisateurRepository.save(utilisateur);
        // Return the new dto
        return UtilisateurEntityToDto(utilisateur);
    }

    @Override
    public UtilisateurDto getUtilisateurById(Long utilisateurDtoId) {
        return null;
    }


    public UtilisateurDto getutilisateurById(Long utilisateurId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElseThrow(() -> new EntityNotFoundException("Utilisateur not found"));
        return UtilisateurEntityToDto(utilisateur);
    }

    @Override
    public boolean deleteUtilisateur(Long utilisateurId) {
        utilisateurRepository.deleteById(utilisateurId);
        return true;
    }

    @Override
    public List<UtilisateurDto> getAllUtilisateur() {
        return null;
    }


    public List<UtilisateurDto> getAllUtilisateurs() {
        List<UtilisateurDto> utilisateurDtos = new ArrayList<>();
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        utilisateurs.forEach(Utilisateur -> {
            utilisateurDtos.add(UtilisateurEntityToDto(Utilisateur));
        });
        return utilisateurDtos;
    }

    /**
     * Map Utilisateur dto to Utilisateur entity
     */
    private UtilisateurDto UtilisateurEntityToDto(Utilisateur utilisateur){
        UtilisateurDto utilisateurDto = new UtilisateurDto();

        utilisateurDto.setLogin(utilisateur.getLogin());
        utilisateurDto.setMotDePasse(utilisateur.getMotDePasse());
        return utilisateurDto;
    }

    /**
     * Map Utilisateur entity to Utilisateur dto
     */
    private Utilisateur UtilisateurDtoToEntity(UtilisateurDto utilisateurDto){
        Utilisateur utilisateur = new Utilisateur();
        utilisateurDto.setLogin(utilisateur.getLogin());
        utilisateurDto.setMotDePasse(utilisateur.getMotDePasse());
        return utilisateur;
    }


}
