package com.kmichaylov.exsys.service;

import com.kmichaylov.exsys.dto.AnswerDTO;
import com.kmichaylov.exsys.model.Answer;
import com.kmichaylov.exsys.model.Question;
import com.kmichaylov.exsys.repository.AnswerRepository;
import com.kmichaylov.exsys.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    public Optional<Answer> findById(int id) {
        return answerRepository.findById(id);
    }

    public Answer saveAnswer(AnswerDTO answerDTO) {
        Answer answer = new Answer();
        answer.setSampleAnswer(answerDTO.getSampleAnswer());
        answer.setCorrect(answerDTO.isCorrect());

        Optional<Question> question = questionRepository.findById(answerDTO.getQuestionId());
        question.ifPresent(answer::setQuestion);

        return answerRepository.save(answer);
    }

    public Answer updateAnswer(int id, AnswerDTO answerDTO) {
        Optional<Answer> existingAnswer = answerRepository.findById(id);
        if (existingAnswer.isPresent()) {
            Answer answer = existingAnswer.get();
            answer.setSampleAnswer(answerDTO.getSampleAnswer());
            answer.setCorrect(answerDTO.isCorrect());

            Optional<Question> question = questionRepository.findById(answerDTO.getQuestionId());
            question.ifPresent(answer::setQuestion);

            return answerRepository.save(answer);
        } else {
            throw new RuntimeException("Answer not found");
        }
    }

    public void deleteById(int id) {
        answerRepository.deleteById(id);
    }
}
