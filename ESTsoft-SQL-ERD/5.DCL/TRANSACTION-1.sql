INSERT INTO students
VALUES ('jo', 10, '강원도');

SELECT *
FROM students;

COMMIT;

SELECT *
FROM students;

UPDATE students
SET address='경기도'
WHERE name = 'jo';

SELECT *
FROM students;

ROLLBACK;

SELECT *
FROM students;

DELETE
FROM students;

SELECT *
FROM students;

ROLLBACK;

# Transaction - 은행 '송금기능'
# 사전작업 'accounts' 테이블 생성
CREATE TABLE accounts
(
    name    VARCHAR(100) NOT NULL,
    balance INT DEFAULT 0
);

TRUNCATE TABLE accounts;

INSERT INTO accounts
VALUES ('A', 10000),
       ('B', 10000);

SELECT *
FROM accounts;

# A -> B 5000원 송금
# 1. A 계좌에서 5000원 차감
# 2. B 계좌에 5000원 추가

BEGIN;

UPDATE accounts
SET balance = 5000
WHERE name = 'A';


UPDATE accounts
SET balance = 15000
WHERE name = 'B';

ROLLBACK;

COMMIT;