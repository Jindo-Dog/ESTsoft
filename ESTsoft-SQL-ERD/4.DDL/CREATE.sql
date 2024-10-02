# NULL 제약 조건
CREATE TABLE NullTest
(
    col1 VARCHAR(10) NOT NULL,
    col2 VARCHAR(10)
);

INSERT INTO NullTest(col1, col2)
VALUES ('첫번째', '1'),
       ('두번재', '2'),
       ('세번째', NULL);

INSERT INTO NullTest(col1, col2)
VALUES (NULL, 'null 컬럼');

SELECT *
FROM NullTest;

# PRIMARY KEY & DEFAULT 제약 조건
CREATE TABLE DefaultTable
(
    id         INT PRIMARY KEY,
    name       VARCHAR(20) NOT NULL,
    defaultcol VARCHAR(20) DEFAULT '-'
);

INSERT INTO DefaultTable(id, name)
VALUES (1, 'sungteon');

SELECT *
FROM DefaultTable;

# AUTO INCREMENT 제약 조건
CREATE TABLE AutoIncrementTable
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20)
);

INSERT INTO AutoIncrementTable(name)
VALUES ('이름1'),
       ('이름2'),
       ('이름3');

SELECT *
FROM AutoIncrementTable;

# UNIQUE 제약 조건
CREATE TABLE UniqueTable
(
    id    VARCHAR(30) PRIMARY KEY,
    name  VARCHAR(30) NOT NULL,
    email VARCHAR(400) UNIQUE
);

INSERT INTO UniqueTable(id, name, email)
VALUES ('jsy', '조성연', 'js@naver.com'),
       ('lsk', '이슬기', 'ls@gmail.com'),
       ('kkb', '김경빈', 'ls@gmail.com');

# FK 제약조건 - RESTRICT 옵션
CREATE TABLE customer
(
    id      INT PRIMARY KEY,
    name    VARCHAR(10) NOT NULL,
    address VARCHAR(200),
    contact VARCHAR(100)
);

CREATE TABLE orders
(
    id              INT PRIMARY KEY,
    customer_id     INT,
    date            TIMESTAMP DEFAULT NOW(),
    payment         VARCHAR(50),
    amount          INT,
    delivery_amount INT,
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

INSERT INTO customer
VALUES (1, '동해물', '서울', '010-1234-5678'),
       (2, '백두산', '부산', '010-8765-4321');

INSERT INTO orders
VALUES (1, 1, '2023-11-12', '신용카드', 10000, 2500),
       (2, 1, '2023-11-13', '신용카드', 20000, 2500),
       (3, 2, '2023-11-12', '계좌이체', 30000, 3000);

SELECT *
FROM customer;

SELECT *
FROM orders;

# 선행
DELETE
FROM orders
WHERE customer_id = 1;

# 후행
DELETE
FROM customer
WHERE id = 1;

# 선행
DROP TABLE orders;
# 후행
DROP TABLE customer;

# FK 제약조건 - CASCADE 옵션
CREATE TABLE customer
(
    id      INT PRIMARY KEY,
    name    VARCHAR(10) NOT NULL,
    address VARCHAR(200),
    contact VARCHAR(100)
);

CREATE TABLE orders
(
    id              INT PRIMARY KEY,
    customer_id     INT,
    date            TIMESTAMP DEFAULT NOW(),
    payment         VARCHAR(50),
    amount          INT,
    delivery_amount INT,
    FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE CASCADE
);

INSERT INTO customer
VALUES (1, '동해물', '서울', '010-1234-5678'),
       (2, '백두산', '부산', '010-8765-4321');

INSERT INTO orders
VALUES (1, 1, '2023-11-12', '신용카드', 10000, 2500),
       (2, 1, '2023-11-13', '신용카드', 20000, 2500),
       (3, 2, '2023-11-12', '계좌이체', 30000, 3000);

SELECT *
FROM customer;

SELECT *
FROM orders;

DELETE
FROM customer
WHERE id = 1;
# DELETE FROM orders WHERE customer_id = 1; 이 자동으로 실행됨

DROP TABLE orders;
DROP TABLE customer;

# FK 제약조건 - SET NULL 옵션
CREATE TABLE customer
(
    id      INT PRIMARY KEY,
    name    VARCHAR(10) NOT NULL,
    address VARCHAR(200),
    contact VARCHAR(100)
);

CREATE TABLE orders
(
    id              INT PRIMARY KEY,
    customer_id     INT,
    date            TIMESTAMP DEFAULT NOW(),
    payment         VARCHAR(50),
    amount          INT,
    delivery_amount INT,
    FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE SET NULL
);

INSERT INTO customer
VALUES (1, '동해물', '서울', '010-1234-5678'),
       (2, '백두산', '부산', '010-8765-4321');

INSERT INTO orders
VALUES (1, 1, '2023-11-12', '신용카드', 10000, 2500),
       (2, 1, '2023-11-13', '신용카드', 20000, 2500),
       (3, 2, '2023-11-12', '계좌이체', 30000, 3000);

SELECT *
FROM customer;

SELECT *
FROM orders;

DELETE
FROM customer
WHERE id = 1;

