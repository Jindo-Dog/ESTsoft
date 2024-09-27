# SQL문에서 조건문을 작성하는 방법: CASE WHEN THEN
SELECT name,
       address,
       CASE
           WHEN (age < 30) THEN '20대'
           WHEN (age < 40) THEN '30대'
           ELSE '...'
           END AS '나이'
FROM students;

# 스칼라 쿼리의 나쁜 예
SELECT name,
       address,
       (SELECT CASE
                   WHEN (age < 30) THEN '20대'
                   ELSE '30대'
                   END AS '나이'
        FROM students b
        WHERE b.name = a.name) AS '나이'
FROM students a;

# 서브 쿼리는 하나의 row만 반환해야 한다
# SELECT 절에 서브 쿼리를 사용하는 방법
SELECT name,
       age,
       (SELECT AVG(age) FROM students) AS avg_age
FROM students
WHERE age < 30;

# FROM 절에 서브 쿼리를 사용하는 방법
SELECT *
FROM (SELECT name, class_name
      FROM classes
      WHERE class_name IN ('데이터베이스', '알고리즘')) AS c;

# FROM 절에 들어가는 서브 쿼리 + INNER JOIN
SELECT c.*, s.*
FROM (SELECT name, class_name
      FROM classes
      WHERE class_name IN ('데이터베이스', '알고리즘')) AS c
         INNER JOIN students AS s
                    ON c.name = s.name;

SELECT name, age, address
FROM students
WHERE name IN (SELECT name
               FROM classes
               WHERE class_name IN ('데이터베이스', '알고리즘'));

# 위의 쿼리를 JOIN으로 변환한 예
SELECT DISTINCT s.name, s.age, s.address
FROM students AS s
         INNER JOIN classes AS c
                    ON s.name = c.name
WHERE c.class_name IN ('데이터베이스', '알고리즘');
