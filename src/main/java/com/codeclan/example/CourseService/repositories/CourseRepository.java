package com.codeclan.example.CourseService.repositories;

import com.codeclan.example.CourseService.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select c from Course c where c.rating = ?1")
    List<Course> findByRating(int rating);

    List<Course> findByBookings_Customer_Name(String name);





}
