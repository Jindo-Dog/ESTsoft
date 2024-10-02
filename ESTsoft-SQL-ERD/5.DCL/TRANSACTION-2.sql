SELECT *
FROM students;


BEGIN;

UPDATE accounts
SET balance = 5000
WHERE name = 'A';

SELECT *
FROM accounts;

ROLLBACK;

COMMIT;