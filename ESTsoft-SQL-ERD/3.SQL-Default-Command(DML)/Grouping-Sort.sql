SELECT address, COUNT(*)
FROM students
GROUP BY address;

SELECT address, COUNT(*)
FROM students
WHERE age >= 30
GROUP BY address;

SELECT MAX(age) AS age
FROM students
GROUP BY address;

SELECT address, AVG(age)
FROM students
GROUP BY address;

SELECT address, COUNT(*)
FROM students
GROUP BY address
HAVING COUNT(*) >= 2;

SELECT *
FROM students
ORDER BY age DESC;

SELECT *
FROM students
ORDER BY age DESC
LIMIT 3;

SELECT *
FROM students
ORDER BY age DESC
LIMIT 3 OFFSET 2;

SELECT address, COUNT(*)
FROM students
WHERE age >= 29
GROUP BY address
HAVING COUNT(*) >= 2
ORDER BY COUNT(*) DESC;

SELECT address, COUNT(*)
FROM students
WHERE age >= 29
GROUP BY address
HAVING COUNT(*) >= 3
ORDER BY COUNT(*);
