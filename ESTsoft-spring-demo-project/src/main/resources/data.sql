INSERT INTO Member (id, name)
VALUES (1, 'name1');
INSERT INTO Member (id, name)
VALUES (2, 'name2');
INSERT INTO Member (id, name)
VALUES (3, 'name3');

CREATE TABLE categories
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    type        VARCHAR(200) NOT NULL COMMENT 'category type. menu, post',
    name        VARCHAR(500) NOT NULL UNIQUE,
    description TEXT,
    image       TEXT COMMENT 'category용 icon or bg img url..',
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS `estsoft_test_db`.`posts`;
CREATE TABLE posts
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_id BIGINT       NOT NULL,
    user_id     BIGINT       NOT NULL,
    title       VARCHAR(255) NOT NULL,
    content     TEXT         NOT NULL,
    is_deleted  TINYINT(1) DEFAULT 0,
    deleted_at  TIMESTAMP,
    created_at  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS `estsoft_test_db`.`comments`;
CREATE TABLE comments
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id    BIGINT NOT NULL,
    user_id    BIGINT NOT NULL,
    content    TEXT   NOT NULL,
    is_deleted TINYINT(1) DEFAULT 0,
    deleted_at TIMESTAMP,
    created_at TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS `estsoft_test_db`.`likes`;
CREATE TABLE likes
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id    BIGINT               NOT NULL,
    post_id    BIGINT,
    comment_id BIGINT,
    unlike     TINYINT(1) DEFAULT 0 NOT NULL, -- 좋아요 취소시..
    created_at TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO categories (type, name, description, image)
VALUES ('BBS', '자유게시판', 'post/comment/', 'image link');