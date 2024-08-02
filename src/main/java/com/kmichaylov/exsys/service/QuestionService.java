package com.kmichaylov.exsys.service;

import com.kmichaylov.exsys.dto.QuestionDTO;
import com.kmichaylov.exsys.model.Question;
import com.kmichaylov.exsys.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Optional<Question> findById(int id) {
        return questionRepository.findById(id);
    }

    public Question addQuestion(QuestionDTO questionDTO) {
        Question question = mapToEntity(new Question(), questionDTO);
        return questionRepository.save(question);
    }

    public Question updateQuestion(int id, QuestionDTO questionDTO) {
        return questionRepository.findById(id)
                .map(existingQuestion -> {
                    mapToEntity(existingQuestion, questionDTO);
                    return questionRepository.save(existingQuestion);
                })
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public void deleteById(int id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Question not found");
        }
    }

    private Question mapToEntity(Question question, QuestionDTO questionDTO) {
        question.setParentQuestion(questionDTO.getParentQuestionId());
        question.setQuestionBody(questionDTO.getQuestionBody());
        question.setQuestionId(questionDTO.getQuestionId());
        question.setPoints(questionDTO.getPoints());
        question.setQuestionType(questionDTO.getQuestionType());
        return question;
    }
}
