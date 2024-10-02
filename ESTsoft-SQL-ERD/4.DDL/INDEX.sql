SELECT *
FROM students
WHERE name = '홍길동';

CREATE INDEX idx_students_name ON students (name);

# CREATE INDEX idx_students_created_at_name ON students (created_at, name);

ALTER TABLE students
    DROP INDEX idx_students_name;

