package com.kmichaylov.exsys.service;

import com.kmichaylov.exsys.dto.CourseDTO;
import com.kmichaylov.exsys.model.Course;
import com.kmichaylov.exsys.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class depicting the services for the course entity.
 */
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    public Course addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseYear(courseDTO.getCourseYear());
        return courseRepository.save(course);
    }

    public Course updateCourse(int id, CourseDTO courseDTO) {
        Optional<Course> existingCourseOptional = courseRepository.findById(id);
        if (existingCourseOptional.isPresent()) {
            Course existingCourse = existingCourseOptional.get();
            existingCourse.setCourseName(courseDTO.getCourseName());
            existingCourse.setCourseYear(courseDTO.getCourseYear());
            return courseRepository.save(existingCourse);
        } else {
            throw new RuntimeException("Course not found");
        }
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
}
