package com.controllers;

import com.dtos.CoursDto;
import com.services.impl.CoursServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cours")
public class CoursController {
    private final CoursServiceImpl coursService;

    public CoursController(CoursServiceImpl coursServiceService) {
        this.coursService = coursServiceService;
    }

    /**
     * <p>Get all Courss in the system</p>
     * @return List<CoursDto>
     */
    @GetMapping
    public List<CoursDto> getCourss() {
        return coursService.getAllCourss();
    }

    /**
     * Method to get the Cours based on the ID
     */
    @GetMapping("/{id}")
    public CoursDto getCours(@PathVariable Long id){
        return coursService.getCoursById(id);
    }

    /**
     * Create a new Cours in the system
     */
    @PostMapping
    public CoursDto saveCours(final @RequestBody CoursDto coursDto){
        return coursService.saveCours(coursDto);
    }

    /**
     * Delete a Cours by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteCours(@PathVariable Long id){
        return coursService.deleteCours(id);
    }

}



