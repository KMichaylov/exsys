CREATE TABLE IF NOT EXISTS person
(
    person_id SERIAL PRIMARY KEY,
    full_name VARCHAR                                           NOT NULL,
    email     VARCHAR                                           NOT NULL,
    password  VARCHAR                                           NOT NULL,
    role      VARCHAR(7) CHECK (role IN ('STUDENT', 'TEACHER')) NOT NULL
);

CREATE TABLE course
(
    course_id   SERIAL PRIMARY KEY,
    course_name VARCHAR NOT NULL,
    course_year CHAR(9) NOT NULL
);

CREATE TABLE exam
(
    exam_id        SERIAL PRIMARY KEY,
    course_id      INT     NOT NULL,
    date           DATE,
    duration       INT     NOT NULL,
    type           VARCHAR(10) CHECK (type IN ('REGULAR', 'RESIT')),
    description    VARCHAR,
    points_to_pass REAL    NOT NULL,
    total_points   REAL    NOT NULL,
    is_submitted   BOOLEAN NOT NULL,
    is_graded      BOOLEAN NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course (course_id)
);

CREATE TABLE question
(
    question_id        SERIAL PRIMARY KEY,
    exam_id            INT,
    question_body      VARCHAR                                                                                      NOT NULL,
    question_type      VARCHAR(15) CHECK (question_type IN ('SINGLE_CORRECT', 'MULTIPLE_CORRECT', 'OPEN_QUESTION')) NOT NULL,
    points             REAL,
    parent_question_id INT,
    FOREIGN KEY (exam_id) REFERENCES exam (exam_id),
    FOREIGN KEY (parent_question_id) REFERENCES question (question_id)
);

CREATE TABLE answer
(
    answer_id     SERIAL PRIMARY KEY,
    question_id   INT,
    sample_answer VARCHAR,
    is_correct    BOOLEAN,
    FOREIGN KEY (question_id) REFERENCES question (question_id)
);

CREATE TABLE student_exam
(
    student_exam_id SERIAL PRIMARY KEY,
    student_id      INT,
    exam_id         INT,
    obtained_points REAL    NOT NULL,
    exam_passed     BOOLEAN NOT NULL,
    FOREIGN KEY (student_id) REFERENCES person (person_id),
    FOREIGN KEY (exam_id) REFERENCES exam (exam_id)
);

CREATE TABLE student_answer
(
    student_answer_id SERIAL PRIMARY KEY,
    student_id        INT,
    question_id       INT,
    exam_id           INT,
    answer_id         INT,
    student_answer    VARCHAR,
    score             REAL NOT NULL,
    FOREIGN KEY (student_id) REFERENCES person (person_id),
    FOREIGN KEY (question_id) REFERENCES question (question_id),
    FOREIGN KEY (exam_id) REFERENCES exam (exam_id),
    FOREIGN KEY (answer_id) REFERENCES answer (answer_id)
);
