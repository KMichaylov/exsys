package com.kmichaylov.exsys.repository;

import com.kmichaylov.exsys.enumeration.QuestionType;
import com.kmichaylov.exsys.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository Interface for managing the questions entities/models.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    /**
     * Finds all questions based on the type.
     *
     * @param questionType type of the questions
     * @return list of questions
     */
    List<Question> findByQuestionType(QuestionType questionType);
}