/*INSERT INTO member(name)
VALUES ('이름1'),
       ('이름2'),
       ('이름3');

INSERT INTO article (title, content, created_at, updated_at)
VALUES ('제목1', '내용1', NOW(), NOW()),
       ('제목2', '내용2', NOW(), NOW()),
       ('제목3', '내용3', NOW(), NOW());

INSERT INTO book (id, name, author)
VALUES ('id1', 'name1', 'author1'),
       ('id2', 'name2', 'author2'),
       ('id3', 'name3', 'author3');

DROP TABLE IF EXISTS article;
CREATE TABLE article
(
    article_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title      VARCHAR(255),
    content    TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

DROP TABLE IF EXISTS comment;
CREATE TABLE comment
(
    comment_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    article_id BIGINT NOT NULL,
    body       TEXT,
    created_at TIMESTAMP
);

TRUNCATE TABLE article;
TRUNCATE TABLE comment;

INSERT INTO article(`article_id`, `title`, `content`, `created_at`, `updated_at`)
VALUES (1, '게시글 제목', '게시글 내용', NOW(), NOW()),
       (2, '게시글 제목2', '게시글 내용2', NOW(), NOW()),
       (3, '게시글 제목3', '게시글 내용3', NOW(), NOW()),
       (4, '게시글 제목4', '게시글 내용4', NOW(), NOW()),
       (5, '게시글 제목5', '게시글 내용5', NOW(), NOW());*/