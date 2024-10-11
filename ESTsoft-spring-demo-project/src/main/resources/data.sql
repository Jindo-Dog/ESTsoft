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

# Wallet - account 실습
DROP TABLE IF EXISTS account;
CREATE TABLE `account`
(
    `id`         BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `visible`    BOOLEAN               DEFAULT FALSE,
    `amounts`    BIGINT(11)   NOT NULL DEFAULT 0 COMMENT 'amount of balance for this account',
    `currency`   VARCHAR(255) NOT NULL DEFAULT 'WON' COMMENT 'could be JPY, POINT/USD..',
    `type`       VARCHAR(255) NOT NULL,
    `metadata`   JSON,
    `wallet_id`  BIGINT(11)   NOT NULL,
    `created_at` DATETIME(3)           DEFAULT CURRENT_TIMESTAMP(3),
    `version`    INT                   DEFAULT 1, #
    `updated_at` DATETIME(3)           DEFAULT CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS wallet;
CREATE TABLE `wallet`
(
    `id`         BIGINT(11)   NOT NULL AUTO_INCREMENT,
-- `uuid` varchar(255) NOT NULL UNIQUE 'as identifier',
    `user_id`    VARCHAR(255) NOT NULL,
    `type`       VARCHAR(255) NOT NULL,
    `metadata`   JSON,
    `created_at` DATETIME(3) DEFAULT CURRENT_TIMESTAMP(3),
    `version`    INT         DEFAULT 1,
    `updated_at` DATETIME(3) DEFAULT CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`),
    UNIQUE (`user_id`, `type`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS transaction;
CREATE TABLE `transaction`
(
    `id`               BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `pid`              BIGINT(11)   NOT NULL COMMENT 'id for associated transactions',
    `src_account_id`   BIGINT(11)   NOT NULL,
    `dst_account_id`   BIGINT(11)   NOT NULL,
    `src_user_id`      VARCHAR(255) NOT NULL,
    `dst_user_id`      VARCHAR(255) NOT NULL,
    `src_account_type` VARCHAR(255) NOT NULL,
    `dst_account_type` VARCHAR(255) NOT NULL,
    `src_currency`     VARCHAR(255) NOT NULL DEFAULT 'JPY' COMMENT 'could be POINT/USD..',
    `dst_currency`     VARCHAR(255) NOT NULL DEFAULT 'JPY',
    `src_amount`       BIGINT(11)   NOT NULL DEFAULT 0 COMMENT 'cents if it is money wise',
    `dst_amount`       BIGINT(11)   NOT NULL DEFAULT 0,
    `src_balance`      BIGINT(11)   NOT NULL DEFAULT 0 COMMENT 'up to date balance after this transaction',
    `dst_balance`      BIGINT(11)   NOT NULL DEFAULT 0,
    `metadata`         TEXT,
    `version`          INT                   DEFAULT 1,
    `created_at`       DATETIME(3)           DEFAULT CURRENT_TIMESTAMP(3),
    `updated_at`       DATETIME(3)           DEFAULT CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`),
    INDEX (pid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;