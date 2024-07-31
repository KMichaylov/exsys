package com.kmichaylov.exsys.controller;

import com.kmichaylov.exsys.dto.CourseDTO;
import com.kmichaylov.exsys.model.Course;
import com.kmichaylov.exsys.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseRestController {

    private final CourseService courseService;

    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();

        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Optional<Course>> getCourseById(@PathVariable int courseId) {
        Optional<Course> course = courseService.getCourseById(courseId);

        if (course.isEmpty()) {
            // throw custom error here
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(course);
    }

    @PostMapping("/add-course")
    public ResponseEntity<String> addCourse(@RequestBody CourseDTO courseDTO) {
        courseService.addCourse(courseDTO);
        return ResponseEntity.ok("Successfully added course!");
    }

}
