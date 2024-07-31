package com.kmichaylov.exsys.repository;

import com.kmichaylov.exsys.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Interface for managing the person entities/models.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {


}
