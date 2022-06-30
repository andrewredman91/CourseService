package com.codeclan.example.CourseService.controller;

import com.codeclan.example.CourseService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomersAndFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age
    ) {
        if (name != null) {
            return new ResponseEntity(customerRepository.findByName(name), HttpStatus.OK);
        }
        if (town != null) {
            return new ResponseEntity(customerRepository.findByTown(town), HttpStatus.OK);
        }

        if (age != null) {
            return new ResponseEntity(customerRepository.findByAge(age), HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

}
