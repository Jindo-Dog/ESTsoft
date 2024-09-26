DELETE
FROM students
WHERE name = '이황';

DELETE
FROM students
WHERE age BETWEEN 30 AND 33;

DELETE
FROM classes
WHERE class_name = '자료구조';

DELETE
FROM students
WHERE age >= 40;

DELETE
FROM students
WHERE age BETWEEN 35 AND 37;

DELETE
FROM students;

TRUNCATE TABLE students;

DELETE
FROM classes;

TRUNCATE TABLE classes;

DROP TABLE students;

DROP TABLE classes;