package com.services.impl;

import com.dtos.CoursDto;
import com.entities.Cours;
import com.repositories.CoursRepository;
import com.services.CoursService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("CoursService")
public class CoursServiceImpl implements CoursService {

    private final CoursRepository coursRepository;

    public CoursServiceImpl(CoursRepository coursRepository){
        this.coursRepository = coursRepository;
    }

    @Override
    public CoursDto saveCours(CoursDto coursDto) {
        // Converts the dto to the Cours entity
        Cours cours = CoursDtoToEntity(coursDto);
        // Save the Cours entity
        cours = coursRepository.save(cours);
        // Return the new dto
        return CoursEntityToDto(cours);
    }

    @Override
    public CoursDto getCoursById(Long coursDtoId) {
        return null;
    }


    public CoursDto getcoursById(Long coursId) {
        Cours cours = coursRepository.findById(coursId).orElseThrow(() -> new EntityNotFoundException("Cours not found"));
        return CoursEntityToDto(cours);
    }

    @Override
    public boolean deleteCours(Long coursId) {
        coursRepository.deleteById(coursId);
        return true;
    }

    @Override
    public List<CoursDto> getAllCours() {
        return null;
    }


    public List<CoursDto> getAllCourss() {
        List<CoursDto> coursDtos = new ArrayList<>();
        List<Cours> cours = coursRepository.findAll();
        cours.forEach(cour -> {
            coursDtos.add(CoursEntityToDto(cour));
        });
        return coursDtos;
    }

    /**
     * Map Cours dto to Cours entity
     */
    private CoursDto CoursEntityToDto(Cours cours){
        CoursDto coursDto = new CoursDto();

        coursDto.setCrenaux(cours.getCrenaux());
        coursDto.setIntitule(cours.getIntitule());
        return coursDto;
    }

    /**
     * Map Cours entity to Cours dto
     */
    private Cours CoursDtoToEntity(CoursDto coursDto){
        Cours cours = new Cours();
        coursDto.setCrenaux(cours.getCrenaux());
        coursDto.setIntitule(cours.getIntitule());
        return cours;
    }


}
