package com.kmichaylov.exsys.controller;

import com.kmichaylov.exsys.dto.StudentAnswerDTO;
import com.kmichaylov.exsys.model.StudentAnswer;
import com.kmichaylov.exsys.service.StudentAnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student-answers")
public class StudentAnswerRestController {

    private final StudentAnswerService studentAnswerService;

    public StudentAnswerRestController(StudentAnswerService studentAnswerService) {
        this.studentAnswerService = studentAnswerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentAnswer>> getAllStudentAnswers() {
        List<StudentAnswer> studentAnswers = studentAnswerService.findAll();
        if (studentAnswers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentAnswers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<StudentAnswer>> getStudentAnswerById(@PathVariable int id) {
        Optional<StudentAnswer> studentAnswer = studentAnswerService.findById(id);
        if (studentAnswer.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentAnswer);
    }

    @PostMapping("/add-student-answer")
    public ResponseEntity<String> addStudentAnswer(@RequestBody StudentAnswerDTO studentAnswerDTO) {
        StudentAnswer addedStudentAnswer = studentAnswerService.saveStudentAnswer(studentAnswerDTO);
        return ResponseEntity.ok("Student answer is added successfully!");
    }

    @PutMapping("/update-student-answer/{id}")
    public ResponseEntity<StudentAnswer> updateStudentAnswer(@PathVariable int id, @RequestBody StudentAnswerDTO studentAnswerDTO) {
        StudentAnswer updatedStudentAnswer = studentAnswerService.updateStudentAnswer(id, studentAnswerDTO);
        return ResponseEntity.ok(updatedStudentAnswer);
    }

    @DeleteMapping("/delete-student-answer/{id}")
    public ResponseEntity<String> deleteStudentAnswer(@PathVariable int id) {
        studentAnswerService.deleteById(id);
        return ResponseEntity.ok("Student answer is deleted successfully!");
    }
}
