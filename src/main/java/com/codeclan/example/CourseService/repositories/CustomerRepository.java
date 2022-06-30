package com.codeclan.example.CourseService.repositories;

import com.codeclan.example.CourseService.models.Booking;
import com.codeclan.example.CourseService.models.Course;
import com.codeclan.example.CourseService.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Long>{



}
