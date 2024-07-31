package com.kmichaylov.exsys.repository;

import com.kmichaylov.exsys.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository Interface for managing the exam entities/models.
 */
@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
