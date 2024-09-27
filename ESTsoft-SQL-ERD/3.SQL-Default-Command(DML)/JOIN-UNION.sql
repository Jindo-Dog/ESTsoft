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

SELECT name AS n, age
FROM students
WHERE age < 30
UNION ALL
SELECT name, age
FROM students
WHERE age < 32;


