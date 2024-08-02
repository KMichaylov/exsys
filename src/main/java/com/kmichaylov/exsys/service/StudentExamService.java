package com.kmichaylov.exsys.service;

import com.kmichaylov.exsys.dto.StudentExamDTO;
import com.kmichaylov.exsys.model.StudentExam;
import com.kmichaylov.exsys.model.Exam;
import com.kmichaylov.exsys.model.Person;
import com.kmichaylov.exsys.repository.StudentExamRepository;
import com.kmichaylov.exsys.repository.ExamRepository;
import com.kmichaylov.exsys.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentExamService {
    private final StudentExamRepository studentExamRepository;
    private final ExamRepository examRepository;
    private final PersonRepository personRepository;

    public StudentExamService(StudentExamRepository studentExamRepository,
                              ExamRepository examRepository,
                              PersonRepository personRepository) {
        this.studentExamRepository = studentExamRepository;
        this.examRepository = examRepository;
        this.personRepository = personRepository;
    }

    public List<StudentExam> findAll() {
        return studentExamRepository.findAll();
    }

    public Optional<StudentExam> findById(int id) {
        return studentExamRepository.findById(id);
    }

    public StudentExam saveStudentExam(StudentExamDTO studentExamDTO) {
        StudentExam studentExam = new StudentExam();
        studentExam.setObtainedPoints(studentExamDTO.getObtainedPoints());
        studentExam.setExamPassed(studentExamDTO.isExamPassed());

        Optional<Exam> exam = examRepository.findById(studentExamDTO.getExamId());
        Optional<Person> person = personRepository.findById(studentExamDTO.getPersonId());

        exam.ifPresent(studentExam::setExam);
        person.ifPresent(studentExam::setPerson);

        return studentExamRepository.save(studentExam);
    }

    public StudentExam updateStudentExam(int id, StudentExamDTO studentExamDTO) {
        Optional<StudentExam> existingStudentExam = studentExamRepository.findById(id);
        if (existingStudentExam.isPresent()) {
            StudentExam studentExam = existingStudentExam.get();
            studentExam.setObtainedPoints(studentExamDTO.getObtainedPoints());
            studentExam.setExamPassed(studentExamDTO.isExamPassed());

            Optional<Exam> exam = examRepository.findById(studentExamDTO.getExamId());
            Optional<Person> person = personRepository.findById(studentExamDTO.getPersonId());

            exam.ifPresent(studentExam::setExam);
            person.ifPresent(studentExam::setPerson);

            return studentExamRepository.save(studentExam);
        } else {
            throw new RuntimeException("StudentExam not found");
        }
    }

    public void deleteById(int id) {
        studentExamRepository.deleteById(id);
    }
}
