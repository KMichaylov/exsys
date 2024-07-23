CREATE TABLE IF NOT EXISTS person (
    person_id VARCHAR(8) UNIQUE,
    full_name VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    role VARCHAR(7) CHECK (role IN ('student', 'teacher')) NOT NULL,
    PRIMARY KEY (person_id)
);

CREATE SEQUENCE s_seq START 0 INCREMENT 1 MINVALUE 0 MAXVALUE 9999999 CYCLE;
CREATE SEQUENCE t_seq START 0 INCREMENT 1 MINVALUE 0 MAXVALUE 9999999 CYCLE;

CREATE OR REPLACE FUNCTION generate_person_id() 
RETURNS TRIGGER AS $$
DECLARE
    new_id VARCHAR(8);
BEGIN
    IF NEW.person_id IS NULL THEN
        IF NEW.role = 'student' THEN
            new_id := 's' || LPAD(nextval('s_seq')::text, 7, '0');
        ELSIF NEW.role = 'teacher' THEN
            new_id := 't' || LPAD(nextval('t_seq')::text, 7, '0');
        ELSE
            RAISE EXCEPTION 'Invalid role. Must be ''student'' or ''teacher''';
        END IF;
        NEW.person_id := new_id;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_person_id
BEFORE INSERT ON person
FOR EACH ROW
EXECUTE FUNCTION generate_person_id();

CREATE TABLE course (
    course_id SERIAL PRIMARY KEY,
    course_name VARCHAR NOT NULL,
    course_year CHAR(9) NOT NULL
);

CREATE TABLE exam (
    exam_id SERIAL PRIMARY KEY,
    course_id INT NOT NULL,
    date DATE,
    duration INT NOT NULL,
    type VARCHAR(10) CHECK (type IN ('regular', 'resit')),
    description VARCHAR,
    points_to_pass REAL NOT NULL,
    total_points REAL NOT NULL,
    is_submitted BOOLEAN NOT NULL,
    is_graded BOOLEAN NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course (course_id)
);

CREATE TABLE question (
    question_id SERIAL PRIMARY KEY,
    exam_id INT,
    question_body VARCHAR NOT NULL,
    question_type VARCHAR(15) CHECK (question_type IN ('multiple_choice', 'multiple_correct', 'open_question')) NOT NULL,
    FOREIGN KEY (exam_id) REFERENCES exam (exam_id)
);

CREATE TABLE answer (
    answer_id SERIAL PRIMARY KEY,
    question_id INT,
    sample_answer VARCHAR,
    is_correct BOOLEAN,
    FOREIGN KEY (question_id) REFERENCES question (question_id)
);

CREATE TABLE student_exam (
    student_exam_id SERIAL PRIMARY KEY,
    student_id VARCHAR(8),
    exam_id INT,
    obtained_points REAL NOT NULL,
    exam_passed BOOLEAN NOT NULL,
    FOREIGN KEY (student_id) REFERENCES person (person_id),
    FOREIGN KEY (exam_id) REFERENCES exam (exam_id)
);

CREATE TABLE student_answer (
    student_answer_id SERIAL PRIMARY KEY,
    student_id VARCHAR(8),
    question_id INT,
    exam_id INT,
    answer_id INT,
    student_answer VARCHAR,
    score REAL NOT NULL,
    FOREIGN KEY (student_id) REFERENCES person (person_id),
    FOREIGN KEY (question_id) REFERENCES question (question_id),
    FOREIGN KEY (exam_id) REFERENCES exam (exam_id),
    FOREIGN KEY (answer_id) REFERENCES answer (answer_id)
);
