package com.codeclan.example.CourseService.controller;

import com.codeclan.example.CourseService.models.Course;
import com.codeclan.example.CourseService.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity getAllCoursesAndFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "rating") Integer rating
    ) {
        if (name != null) {
            return new ResponseEntity(courseRepository.findByName(name), HttpStatus.OK);
        }
            if (town != null) {
                return new ResponseEntity(courseRepository.findByTown(town), HttpStatus.OK);
            }

            if (rating != null) {
                return new ResponseEntity(courseRepository.findByRating(rating), HttpStatus.OK);
            }
            return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
        }

    }