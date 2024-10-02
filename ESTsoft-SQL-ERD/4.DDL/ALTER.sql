SELECT *
FROM students;

# 열 추가
ALTER TABLE students
    ADD grade VARCHAR(200);

# 열 이름 변경
ALTER TABLE students
    RENAME COLUMN grade TO great;

# 열 타입 변경
ALTER TABLE students
    MODIFY COLUMN great VARCHAR(300);

# 열 삭제
ALTER TABLE students
    DROP COLUMN great;

