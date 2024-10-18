INSERT INTO member(name)
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