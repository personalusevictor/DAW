/* 
1. Un procedimiento almacenado que liste a todos los jugadores que tiene la base de datos baloncesto del curso dado en la llamada al 
procedimiento.
*/

DELIMITER //
CREATE PROCEDURE JugadoresPorCurso(IN p_curso CHAR(3))
BEGIN
    SELECT *
    FROM Jugadores
    WHERE clase IN (SELECT grupo FROM clases WHERE nombre = p_curso);
END //
DELIMITER ;

-- 2. Un procedimiento almacenado que me diga cuantas clases de la ESO hay en la base de datos.

DELIMITER //
CREATE PROCEDURE NumeroClasesESO()
BEGIN
    SELECT COUNT(*) AS total_clases_eso
    FROM Clases
    WHERE codigo LIKE 'E%';
END //
DELIMITER ;

/* 
3. Llama a un procedimiento almacenado que devuelve todos los jugadores cuyo nombre empieza por la letra indicada al llamarlo y los tantos 
marcados sean mayor que los dados en la llamada. Por ejemplo call Ejercicio3 ('A', 10); me muestra los jugadores que tengan nombre comienza 
por A y haya manrcado de de 10 puntos. 
*/

DELIMITER //
CREATE PROCEDURE Ejercicio3(
    IN p_letra CHAR(1),
    IN p_puntos INT
)
BEGIN
    SELECT *
    FROM Jugadores
    WHERE nombre LIKE CONCAT(p_letra, '%')
      AND tantos_marcados > p_puntos;
END //
DELIMITER ;

/* 
4. En la base de datos BALONCESTO crea dos tablas llamadas clases_bach y clases_cf, con la misma estructura que la tabla clases que ya 
existe. En una almacenaremos los jugadores de la ESO, en la otra de Bachillerato y en la última los de Ciclos Formativos. Crea un procedimiento 
almacenado para cargar las tablas. (dependiendo del código del grupo los datos se introducen en una tabla u otra). Para insertar los datos 
depende del código de la clase:

    Si empieza por E(ESO) el grupo se inserta en la tabla CLASES.
    Si empieza por B (Bachillerato) se inserta en la tabla CLASES_BACH.
    Si empieza por C se inserta en la tabla CLASES_CF.
*/


CREATE TABLE Clases_Bach LIKE Clases;
CREATE TABLE Clases_CF LIKE Clases;

DELIMITER //
CREATE PROCEDURE InsertarClase(
    IN p_codigo CHAR(3)
    IN p_grupo VARCHAR(20)
    IN p_nombre_tutor VARCHAR(40)
    IN p_puntuacion INT
    IN p_capitan CHAR(7)
)
BEGIN
    IF p_codigo LIKE 'E%' THEN
        INSERT INTO Clases VALUES (p_codigo, p_grupo, p_nombre_tutor, p_puntuacion, p_capitan);
    ELSEIF p_codigo LIKE 'B%' THEN
        INSERT INTO Clases_Bach VALUES (p_codigo, p_grupo, p_nombre_tutor, p_puntuacion, p_capitan);
    ELSEIF p_codigo LIKE 'C%' THEN
        INSERT INTO Clases_CF VALUES (p_codigo, p_grupo, p_nombre_tutor, p_puntuacion, p_capitan);
    END IF;
END //
DELIMITER ;

-- LLAMADAS DE PRUEBA

-- CALL JugadoresPorCurso('E1A');
-- CALL NumeroClasesESO();
-- CALL Ejercicio3('A',10);
-- CALL RepartirClases();