package com.kmichaylov.exsys.repository;

import com.kmichaylov.exsys.model.StudentExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentExamRepository extends JpaRepository<StudentExam, Integer> {
}
