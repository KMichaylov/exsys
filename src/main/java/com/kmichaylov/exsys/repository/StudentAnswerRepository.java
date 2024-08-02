package com.kmichaylov.exsys.repository;

import com.kmichaylov.exsys.model.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, Integer> {
}
