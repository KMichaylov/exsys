package com.kmichaylov.exsys.controller;

import com.kmichaylov.exsys.dto.StudentExamDTO;
import com.kmichaylov.exsys.model.StudentExam;
import com.kmichaylov.exsys.service.StudentExamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student-exams")
public class StudentExamRestController {

    private final StudentExamService studentExamService;

    public StudentExamRestController(StudentExamService studentExamService) {
        this.studentExamService = studentExamService;
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentExam>> getAllStudentExams() {
        List<StudentExam> studentExams = studentExamService.findAll();
        if (studentExams.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentExams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<StudentExam>> getStudentExamById(@PathVariable int id) {
        Optional<StudentExam> studentExam = studentExamService.findById(id);
        if (studentExam.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentExam);
    }

    @PostMapping("/add-student-exam")
    public ResponseEntity<String> addStudentExam(@RequestBody StudentExamDTO studentExamDTO) {
        StudentExam addedStudentExam = studentExamService.saveStudentExam(studentExamDTO);
        return ResponseEntity.ok("Student exam is added successfully!");
    }

    @PutMapping("/update-student-exam/{id}")
    public ResponseEntity<StudentExam> updateStudentExam(@PathVariable int id, @RequestBody StudentExamDTO studentExamDTO) {
        StudentExam updatedStudentExam = studentExamService.updateStudentExam(id, studentExamDTO);
        return ResponseEntity.ok(updatedStudentExam);
    }

    @DeleteMapping("/delete-student-exam/{id}")
    public ResponseEntity<String> deleteStudentExam(@PathVariable int id) {
        studentExamService.deleteById(id);
        return ResponseEntity.ok("Student exam is deleted successfully!");
    }
}
