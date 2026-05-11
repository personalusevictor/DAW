-- 1
CREATE DATABASE transa;
use transa;

CREATE TABLE tabla1 (
	column1 INTEGER
);

-- 2
SHOW VARIABLES LIKE 'autocommit';

-- 3
START TRANSACTION;
UPDATE tabla1
set colum1 = colum1 + 10;
INSERT INTO tabla1 VALUES(100);
COMMIT;
SELECT * FROM tabla1;

-- 4
START TRANSACTION;
INSERT INTO tabla1 VALUES(5), (15);
UPDATE tabla1
SET colum1 = colum1 + 100;
ROLLBACK;
SELECT * FROM tabla1;

-- 5
START TRANSACTION;
CREATE TABLE tabla2 (
	colum2 CHAR
);
INSERT INTO tabla2 VALUES('A'),('B');
ROLLBACK;
-- comprobación: no se ha podido deshacer, pues hay una sentencia DDL
SHOW TABLES;
SELECT * FROM tabla2;

-- 6
START TRANSACTION;
DROP DATABASE transa;
-- comprobación: no se puede deshacer, pues es una sentencia DDL
SHOW DATABASES