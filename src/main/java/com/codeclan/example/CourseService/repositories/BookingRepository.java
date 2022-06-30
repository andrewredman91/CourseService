package com.codeclan.example.CourseService.repositories;

import com.codeclan.example.CourseService.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository <Booking, Long>{

}
