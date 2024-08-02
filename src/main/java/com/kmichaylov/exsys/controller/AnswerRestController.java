package com.kmichaylov.exsys.controller;

import com.kmichaylov.exsys.dto.AnswerDTO;
import com.kmichaylov.exsys.model.Answer;
import com.kmichaylov.exsys.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/answers")
public class AnswerRestController {

    private final AnswerService answerService;

    public AnswerRestController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = answerService.findAll();
        if (answers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Answer>> getAnswerById(@PathVariable int id) {
        Optional<Answer> answer = answerService.findById(id);
        if (answer.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(answer);
    }

    @PostMapping("/add-answer")
    public ResponseEntity<String> addAnswer(@RequestBody AnswerDTO answerDTO) {
        Answer addedAnswer = answerService.saveAnswer(answerDTO);
        return ResponseEntity.ok("Answer is added successfully!");
    }

    @PutMapping("/update-answer/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable int id, @RequestBody AnswerDTO answerDTO) {
        Answer updatedAnswer = answerService.updateAnswer(id, answerDTO);
        return ResponseEntity.ok(updatedAnswer);
    }

    @DeleteMapping("/delete-answer/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable int id) {
        answerService.deleteById(id);
        return ResponseEntity.ok("Answer is deleted successfully!");
    }
}
