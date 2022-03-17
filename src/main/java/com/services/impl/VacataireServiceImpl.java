package com.services.impl;

import com.dtos.VacataireDto;
import com.entities.Vacataire;
import com.repositories.VacataireRepository;
import com.services.VacataireService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("vacataireService")
public class VacataireServiceImpl implements VacataireService {

    private final VacataireRepository vacataireRepository;

    public VacataireServiceImpl(VacataireRepository vacataireRepository){
        this.vacataireRepository = vacataireRepository;
    }

    @Override
    public VacataireDto saveVacataire(VacataireDto vacataireDto) {
        // Converts the dto to the vacataire entity
        Vacataire vacataire = VacataireDtoToEntity(vacataireDto);
        // Save the vacataire entity
        vacataire = vacataireRepository.save(vacataire);
        // Return the new dto
        return VacataireEntityToDto(vacataire);
    }

    @Override
    public VacataireDto getVacataireById(Long vacataireDtoId) {
        return null;
    }


    public VacataireDto getvacataireById(Long vacataireId) {
        Vacataire vacataire = vacataireRepository.findById(vacataireId).orElseThrow(() -> new EntityNotFoundException("vacataire not found"));
        return VacataireEntityToDto(vacataire);
    }

    @Override
    public boolean deleteVacataire(Long vacataireId) {
        vacataireRepository.deleteById(vacataireId);
        return true;
    }

    @Override
    public List<VacataireDto> getAllVacataire() {
        return null;
    }


    public List<VacataireDto> getAllVacataires() {
        List<VacataireDto> vacataireDtos = new ArrayList<>();
        List<Vacataire> vacataires = vacataireRepository.findAll();
        vacataires.forEach(vacataire -> {
            vacataireDtos.add(VacataireEntityToDto(vacataire));
        });
        return vacataireDtos;
    }

    /**
     * Map vacataire dto to vacataire entity
     */
    private VacataireDto VacataireEntityToDto(Vacataire vacataire){
        VacataireDto vacataireDto = new VacataireDto();

        vacataireDto.setParticipe(vacataire.getParticipe());
        vacataireDto.setEffectue(vacataire.getEffectue());
        return vacataireDto;
    }

    /**
     * Map vacataire entity to vacataire dto
     */
    private Vacataire VacataireDtoToEntity(VacataireDto vacataireDto){
        Vacataire vacataire = new Vacataire();
        vacataireDto.setParticipe(vacataire.getParticipe());
        vacataireDto.setEffectue(vacataire.getEffectue());
        return vacataire;
    }


}
