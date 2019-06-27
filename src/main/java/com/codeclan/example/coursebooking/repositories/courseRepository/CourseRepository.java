package com.codeclan.example.coursebooking.repositories.courseRepository;

import com.codeclan.example.coursebooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {

    List<Course> findCoursesByRating(int rating);

    List<Course> findCoursesByBookings_CustomerId(Long id);

}
