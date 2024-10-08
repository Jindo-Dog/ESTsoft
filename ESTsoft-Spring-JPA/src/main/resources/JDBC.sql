-- create database test;
-- use test;
--

DROP TABLE IF EXISTS student;
CREATE TABLE `student`
(
    `id`         BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(255) NOT NULL,
    `age`        SMALLINT     NOT NULL,
    `desc`       TEXT COMMENT 'blah blah.....',
    `created_at` DATETIME(3) DEFAULT CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- cf
SELECT CURRENT_TIMESTAMP, CURRENT_TIMESTAMP(3), CURRENT_TIMESTAMP(1), CURRENT_TIMESTAMP(2), CURRENT_TIMESTAMP(4);

DROP TABLE IF EXISTS instructor;
CREATE TABLE `instructor`
(
    `id`         BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(255) NOT NULL,
    `left`       BOOLEAN     DEFAULT FALSE,
    `desc`       TEXT COMMENT 'blah blah.....',
    `created_at` DATETIME(3) DEFAULT CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS lecture_course;
CREATE TABLE `lecture_course`
(
    `id`            BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `title`         VARCHAR(255) NOT NULL,
    `instructor_id` BIGINT(11)   NOT NULL,
    `capacity`      SMALLINT     NOT NULL DEFAULT 50,
    `from`          DATETIME              DEFAULT CURRENT_TIMESTAMP,
    `to`            DATETIME              DEFAULT CURRENT_TIMESTAMP,
    `desc`          TEXT COMMENT 'blah blah.....',
    `created_at`    DATETIME(3)           DEFAULT CURRENT_TIMESTAMP(3),
    `updated_at`    DATETIME(3)           DEFAULT CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS lecture_applicants;
CREATE TABLE `lecture_applicants`
(
    `id`                BIGINT(11) NOT NULL AUTO_INCREMENT,
    `lecture_course_id` BIGINT(11) NOT NULL,
    `student_id`        BIGINT(11) NOT NULL,
    `created_at`        DATETIME(3) DEFAULT CURRENT_TIMESTAMP(3),
    `updated_at`        DATETIME(3) DEFAULT CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS attendance;
CREATE TABLE `attendance`
(
    `id`                BIGINT(11) NOT NULL AUTO_INCREMENT,
    `lecture_course_id` BIGINT(11) NOT NULL,
    `student_id`        BIGINT(11) NOT NULL,
    `created_at`        DATETIME(3) DEFAULT CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`)
);

-- sample data. ID column, default values
INSERT INTO student(name, age, created_at)
VALUES ('김철수', 25, NOW());
INSERT INTO instructor(name, created_at)
VALUES ('김강사', NOW());
INSERT INTO lecture_course(title, instructor_id, capacity, `from`, `to`)
VALUES ('java', 1, 70, '2024-03-05', '2024-03-08');
INSERT INTO lecture_applicants(lecture_course_id, student_id)
VALUES (1, 1);