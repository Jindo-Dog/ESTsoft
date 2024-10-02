CREATE USER test_user IDENTIFIED BY '1234';

GRANT SELECT ON ESTsoft_test_db.students TO test_user;

REVOKE SELECT ON ESTsoft_test_db.students FROM test_user;
REVOKE SELECT ON *.* FROM test_user@localhost;