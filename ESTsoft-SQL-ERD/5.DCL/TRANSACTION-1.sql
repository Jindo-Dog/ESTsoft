INSERT INTO students
VALUES ('jo', 10, '강원도');

# 다른 세션에서도 조회 해보기
SELECT *
FROM students;

COMMIT;

# commit 후 다른 세션에서도 테이블 데이터 조회 해보기
SELECT *
FROM students;

# UPDATE / 트랜잭션 ROLLBACK 테스트
UPDATE students
SET address='경기도'
WHERE name = 'jo';

SELECT *
FROM students;

ROLLBACK;

SELECT *
FROM students;

# DELETE / 트랜잭션 ROLLBACK 테스트
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

# 트랜잭션 성공(commit) 혹은 취소(rollback) 실습 해보기
ROLLBACK;
COMMIT;