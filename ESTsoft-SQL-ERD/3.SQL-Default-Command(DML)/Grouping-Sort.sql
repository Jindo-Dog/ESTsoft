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

# LIMIT
SELECT *
FROM students
ORDER BY age DESC
LIMIT 3;

# OFFSET
SELECT *
FROM students
ORDER BY age DESC
LIMIT 3 OFFSET 2;

SELECT address, COUNT(*) AS cnt
FROM students
GROUP BY address
ORDER BY cnt
LIMIT 5 OFFSET 2;

SELECT address, COUNT(*) AS cnt
FROM students
WHERE age >= 29
GROUP BY address
HAVING COUNT(*) >= 3
ORDER BY cnt DESC;

# 모두
SELECT address, COUNT(*) AS cnt
FROM students
WHERE age >= 29
GROUP BY address
HAVING cnt >= 2
ORDER BY cnt DESC;

SELECT address, COUNT(*) AS cnt
FROM students
WHERE age >= 29
GROUP BY address
HAVING cnt >= 3
ORDER BY cnt;
