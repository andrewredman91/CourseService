package com.codeclan.example.CourseService.controller;

import com.codeclan.example.CourseService.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity getAllCoursesAndFilters(
            @RequestParam(required = false, name = "date") String date,
            @RequestParam(required = false, name = "courseName") String courseName,
            @RequestParam(required = false, name = "customerName") String customerName
    ) {
        if (date != null) {
            return new ResponseEntity(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        if (courseName != null) {
            return new ResponseEntity(bookingRepository.findByCourseName(courseName), HttpStatus.OK);
        }

        if (customerName != null) {
            return new ResponseEntity(bookingRepository.findByCustomerName(customerName), HttpStatus.OK);
        }
        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }

}
