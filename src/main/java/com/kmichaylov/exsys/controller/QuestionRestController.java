package com.kmichaylov.exsys.controller;

import com.kmichaylov.exsys.dto.QuestionDTO;
import com.kmichaylov.exsys.model.Question;
import com.kmichaylov.exsys.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("questions")
public class QuestionRestController {

    private QuestionService questionService;

    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Question>> getQuestions() {
        List<Question> questions = questionService.findAll();
        if (questions.isEmpty()) {
            // throw custom error here
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable int id) {
        Optional<Question> question = questionService.findById(id);
        if (question.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(question);
    }

    @PostMapping("/add-question")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionDTO questionDTO) {
        Question addedQuestion = questionService.addQuestion(questionDTO);
        return ResponseEntity.ok("Question is added successfully!");
    }

    @PutMapping("/update-question/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable int id, @RequestBody QuestionDTO questionDTO) {
        Question updatedQuestion = questionService.updateQuestion(id, questionDTO);
        return ResponseEntity.ok(updatedQuestion);
    }

    @DeleteMapping("/delete-question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        questionService.deleteById(id);
        return ResponseEntity.ok("Question deleted successfully!");
    }
}
