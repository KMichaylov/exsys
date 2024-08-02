package com.kmichaylov.exsys.controller;

import com.kmichaylov.exsys.dto.ExamDTO;
import com.kmichaylov.exsys.model.Exam;
import com.kmichaylov.exsys.service.ExamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("exams")
public class ExamRestController {

    private ExamService examService;

    public ExamRestController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Exam>> getExams() {
        List<Exam> exams = examService.findAll();
        if (exams.isEmpty()) {
            // throw custom error here
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(exams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Exam>> getExamById(@PathVariable int id) {
        Optional<Exam> exam = examService.findById(id);

        if (exam.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(exam);
    }

    @PostMapping("/add-exam")
    public ResponseEntity<String> addExam(@RequestBody ExamDTO examDTO) {
        Exam addedExam = examService.addExam(examDTO);
        return ResponseEntity.ok("Exam is added successfully!");
    }

    @PutMapping("/update-exam/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable int id, @RequestBody ExamDTO examDTO) {
        Exam updatedExam = examService.updateExam(id, examDTO);
        return ResponseEntity.ok(updatedExam);
    }

}
