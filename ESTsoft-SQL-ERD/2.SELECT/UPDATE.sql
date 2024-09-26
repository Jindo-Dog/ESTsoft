UPDATE students
SET age = 99
WHERE name = '이황';

UPDATE students
SET age     = 10,
    address = '서울특별시'
WHERE name = '정약용';

UPDATE students
SET address='인천광역시'
WHERE age < 33;