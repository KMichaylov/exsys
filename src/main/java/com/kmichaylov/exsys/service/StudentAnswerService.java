package com.kmichaylov.exsys.service;

import com.kmichaylov.exsys.dto.StudentAnswerDTO;
import com.kmichaylov.exsys.model.StudentAnswer;
import com.kmichaylov.exsys.model.Answer;
import com.kmichaylov.exsys.model.Exam;
import com.kmichaylov.exsys.model.Person;
import com.kmichaylov.exsys.model.Question;
import com.kmichaylov.exsys.repository.StudentAnswerRepository;
import com.kmichaylov.exsys.repository.AnswerRepository;
import com.kmichaylov.exsys.repository.ExamRepository;
import com.kmichaylov.exsys.repository.PersonRepository;
import com.kmichaylov.exsys.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAnswerService {
    private final StudentAnswerRepository studentAnswerRepository;
    private final AnswerRepository answerRepository;
    private final ExamRepository examRepository;
    private final PersonRepository personRepository;
    private final QuestionRepository questionRepository;

    public StudentAnswerService(StudentAnswerRepository studentAnswerRepository,
                                AnswerRepository answerRepository,
                                ExamRepository examRepository,
                                PersonRepository personRepository,
                                QuestionRepository questionRepository) {
        this.studentAnswerRepository = studentAnswerRepository;
        this.answerRepository = answerRepository;
        this.examRepository = examRepository;
        this.personRepository = personRepository;
        this.questionRepository = questionRepository;
    }

    public List<StudentAnswer> findAll() {
        return studentAnswerRepository.findAll();
    }

    public Optional<StudentAnswer> findById(int id) {
        return studentAnswerRepository.findById(id);
    }

    public StudentAnswer saveStudentAnswer(StudentAnswerDTO studentAnswerDTO) {
        StudentAnswer studentAnswer = new StudentAnswer();
        studentAnswer.setStudentAnswer(studentAnswerDTO.getStudentAnswer());
        studentAnswer.setScore(studentAnswerDTO.getScore());

        Optional<Exam> exam = examRepository.findById(studentAnswerDTO.getExamId());
        Optional<Person> person = personRepository.findById(studentAnswerDTO.getPersonId());
        Optional<Answer> answer = answerRepository.findById(studentAnswerDTO.getAnswerId());
        Optional<Question> question = questionRepository.findById(studentAnswerDTO.getQuestionId());

        exam.ifPresent(studentAnswer::setExam);
        person.ifPresent(studentAnswer::setPerson);
        answer.ifPresent(studentAnswer::setAnswer);
        question.ifPresent(studentAnswer::setQuestion);

        return studentAnswerRepository.save(studentAnswer);
    }

    public StudentAnswer updateStudentAnswer(int id, StudentAnswerDTO studentAnswerDTO) {
        Optional<StudentAnswer> existingStudentAnswer = studentAnswerRepository.findById(id);
        if (existingStudentAnswer.isPresent()) {
            StudentAnswer studentAnswer = existingStudentAnswer.get();
            studentAnswer.setStudentAnswer(studentAnswerDTO.getStudentAnswer());
            studentAnswer.setScore(studentAnswerDTO.getScore());

            Optional<Exam> exam = examRepository.findById(studentAnswerDTO.getExamId());
            Optional<Person> person = personRepository.findById(studentAnswerDTO.getPersonId());
            Optional<Answer> answer = answerRepository.findById(studentAnswerDTO.getAnswerId());
            Optional<Question> question = questionRepository.findById(studentAnswerDTO.getQuestionId());

            exam.ifPresent(studentAnswer::setExam);
            person.ifPresent(studentAnswer::setPerson);
            answer.ifPresent(studentAnswer::setAnswer);
            question.ifPresent(studentAnswer::setQuestion);

            return studentAnswerRepository.save(studentAnswer);
        } else {
            throw new RuntimeException("StudentAnswer not found");
        }
    }

    public void deleteById(int id) {
        studentAnswerRepository.deleteById(id);
    }
}
