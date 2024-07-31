package com.kmichaylov.exsys.service;

import com.kmichaylov.exsys.dto.ExamDTO;
import com.kmichaylov.exsys.model.Exam;
import com.kmichaylov.exsys.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    @Autowired
    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    public Optional<Exam> findById(int id) {
        return examRepository.findById(id);
    }

    public Exam addExam(ExamDTO examDTO) {
        Exam exam = new Exam();
        exam.setCourse(examDTO.getCourse());
        exam.setDate(examDTO.getDate());
        exam.setDuration(examDTO.getDuration());
        exam.setType(examDTO.getType());
        exam.setDescription(examDTO.getDescription());
        exam.setPointsToPass(examDTO.getPointsToPass());
        exam.setTotalPoints(examDTO.getTotalPoints());
        return examRepository.save(exam);
    }

    public Exam updateExam(int id, ExamDTO examDTO) {
        Optional<Exam> existingExamOptional = examRepository.findById(id);
        if (existingExamOptional.isPresent()) {
            Exam existingExam = existingExamOptional.get();
            existingExam.setCourse(examDTO.getCourse());
            existingExam.setDate(examDTO.getDate());
            existingExam.setDuration(examDTO.getDuration());
            existingExam.setType(examDTO.getType());
            existingExam.setDescription(examDTO.getDescription());
            existingExam.setPointsToPass(examDTO.getPointsToPass());
            existingExam.setTotalPoints(examDTO.getTotalPoints());
            return examRepository.save(existingExam);
        } else {
            throw new RuntimeException("Exam not found");
        }
    }

    public void deleteById(int id) {
        examRepository.deleteById(id);
    }
}
