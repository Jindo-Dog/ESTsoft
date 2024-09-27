SELECT *
FROM students AS s
         INNER JOIN classes AS c
                    ON s.name = c.name;

SELECT *
FROM students AS s
         LEFT OUTER JOIN classes AS c ON s.name = c.name;

SELECT *
FROM students AS s
         RIGHT OUTER JOIN classes AS c ON s.name = c.name;

SELECT age, address, c.name, class_name
FROM students AS s
         RIGHT OUTER JOIN classes AS c ON s.name = c.name;

# UNION
SELECT name AS n, age
FROM students
WHERE age < 30
UNION
SELECT name, age
FROM students
WHERE age < 32;

# UNION ALL (중복을 처리하지 않기 때문에 처리 속도가 빠름)
SELECT name AS n, age
FROM students
WHERE age < 30
UNION ALL
SELECT name, age
FROM students
WHERE age < 32;


