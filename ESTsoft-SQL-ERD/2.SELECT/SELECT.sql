SELECT name, age, address
FROM students
WHERE address = '경기도';

SELECT name AS col1, age AS col2, address AS col3
FROM students;

SELECT *
FROM students;

SELECT *
FROM students
WHERE age >= 20
  AND age < 30;

SELECT DISTINCT class_name
FROM classes;

SELECT name
FROM classes
WHERE class_name = '데이터베이스';

SELECT class_name
FROM classes
WHERE name = '김광균';

SELECT name
FROM students
WHERE address = '제주도';

