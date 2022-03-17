package com.controllers;

import com.dtos.VacataireDto;
import com.services.impl.VacataireServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacataire")
public class VacataireController {
    private final VacataireServiceImpl vacataireService;

    public VacataireController(VacataireServiceImpl vacataireServiceService) {
        this.vacataireService = vacataireServiceService;
    }

    /**
     * <p>Get all vacataires in the system</p>
     * @return List<VacataireDto>
     */
    @GetMapping
    public List<VacataireDto> getVacataires() {
        return vacataireService.getAllVacataires();
    }

    /**
     * Method to get the vacataire based on the ID
     */
    @GetMapping("/{id}")
    public VacataireDto getvacataire(@PathVariable Long id){
        return vacataireService.getVacataireById(id);
    }

    /**
     * Create a new vacataire in the system
     */
    @PostMapping
    public VacataireDto saveVacataire(final @RequestBody VacataireDto vacataireDto){
        return vacataireService.saveVacataire(vacataireDto);
    }

    /**
     * Delete a vacataire by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteVacataire(@PathVariable Long id){
        return vacataireService.deleteVacataire(id);
    }

}



