# 숫자 관련 내장함수 sum(), avg(), max(), min(), count()
SELECT SUM(age)
FROM students;
SELECT AVG(age)
FROM students;
SELECT MAX(age)
FROM students;
SELECT MIN(age)
FROM students;
SELECT COUNT(DISTINCT address)
FROM students;

# 문자열 관련 내장함수 char_length(), concat(), replace()
SELECT CHAR_LENGTH(name)
FROM students;
SELECT CONCAT(name, ' ', address)
FROM students;
SELECT REPLACE(address, '도', '레')
FROM students;

SELECT MIN(age)
FROM students
WHERE age BETWEEN 30 AND 39;

SELECT AVG(age)
FROM students
WHERE age BETWEEN 20 AND 29;

SELECT COUNT(name)
FROM students
WHERE age >= 35;

# 현재 시간
SELECT now();