INSERT INTO students(name, age, address)
VALUES ('김이박', 40, '서울특별시');

# 실패하는 SQL
INSERT INTO students(name, age)
VALUES ('신기루', 41);

INSERT INTO students(name, age, address)
VALUES ('학생1', 20, '경기도'),
       ('학생2', 22, '경기도'),
       ('학생3', 23, '경기도');

INSERT INTO students (name, age, address)
SELECT name, age, address
FROM students
WHERE age < 30;

INSERT INTO students (name, age, address)
SELECT name, age, address
FROM students
WHERE address = '경상남도';