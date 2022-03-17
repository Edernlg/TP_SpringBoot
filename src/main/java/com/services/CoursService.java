package com.services;

import com.dtos.CoursDto;

import java.util.List;

public interface CoursService {
    /**
     * Save Cours
     */
    CoursDto saveCours(CoursDto coursDto);

    /**
     * Get a Cours by id
     */
    CoursDto getCoursById(Long coursDtoId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteCours(Long CoursId);

    /**
     * Get all the Cours
     */
    List<CoursDto> getAllCours();
}
