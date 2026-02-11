/* 1.-  Obtener el dni de los clientes que han comprado algún coche a un concesionario de 'MADRID'.*/
SELECT DISTINCT dni FROM ventas WHERE cifc IN (SELECT cifc FROM concesionario WHERE ciudad like 'Madrid');

/* 2.- Obtener los codcoche suministrados por algún concesionario de 'BARCELONA'.*/
SELECT codcoche from distribucion WHERE cifc IN (SELECT cifc FROM concesionario WHERE ciudad like 'Barcelona');

/* 3.- Obtener el color de los coches vendidos por el concesionario 'ACAR'. */
SELECT color FROM ventas WHERE cifc IN (SELECT cifc FROM concesionario WHERE nombre like 'ACAR');

/* 4.- Obtener el codcoche de aquellos coches vendidos a clientes de 'MADRID'.*/
SELECT codcoche FROM ventas WHERE dni IN (SELECT dni FROM clientes WHERE ciudad like 'Madrid');

/* 5.- Obtener el codcoche de los coches vendidos por algún concesionario de 'MADRID'. */
SELECT codcoche FROM ventas WHERE cifc IN (SELECT cifc FROM concesionario WHERE ciudad like 'Madrid');

/* 6.- Obtener el nombre y el apellido de los clientes cuyo dni es menor que el del cliente 'JUAN MARTIN'. */
SELECT nombre, apellidos FROM clientes WHERE dni < ANY (SELECT dni FROM clientes WHERE nombre like 'Juan' AND apellidos like 'Martin');

/* 7.- Obtener el nombre y el apellido de los clientes cuyo dni es menor que el de los clientes que son de 'BARCELONA'. */
SELECT nombre, apellidos FROM clientes WHERE dni < ALL (SELECT dni FROM clientes WHERE ciudad like 'Barcelona');

/* 8.- Obtener el nombre y el apellido de los clientes cuyo nombre empieza por 'A' y cuyo dni es mayor que el de los clientes que son de 'MADRID'. */
SELECT nombre, apellidos FROM clientes WHERE nombre like 'A%' AND dni > ALL (SELECT dni FROM clientes WHERE ciudad like 'Madrid');

/* 9.- Obtener el nombre y el apellido de los clientes cuyo nombre empieza por 'A' y cuyo dni es mayor que el de ¡ALGUNO! de los clientes que son de 'MADRID'. */
SELECT nombre, apellidos FROM clientes WHERE nombre like 'A%' AND dni > ANY (SELECT dni FROM clientes WHERE ciudad like 'Madrid');

/* 10.- Obtener el nombre y el apellido de los clientes cuyo nombre empieza por 'A' y cuyo dni es mayor que el de ¡ALGUNO! de los clientes que son de 'MADRID' o menor que el de todos los de 'VALENCIA'. */
SELECT nombre, apellidos FROM clientes WHERE nombre like 'A%' AND (dni > ANY (SELECT dni FROM clientes WHERE ciudad like 'Madrid') OR dni < ALL (SELECT dni FROM clientes WHERE ciudad like 'Valencia'));

/* 11.- Obtener el nombre y el apellido de los clientes que han comprado como mínimo un coche 'BLANCO' y un coche 'ROJO'. */
SELECT nombre, apellidos FROM clientes WHERE dni IN (SELECT dni FROM ventas WHERE color like 'Blanco') AND dni IN (SELECT dni FROM ventas WHERE color like 'Rojo');

/* 12.- Obtener el dni de los clientes cuya ciudad sea la última de la lista alfabética de las ciudades donde hay concesionarios. */
SELECT dni FROM clientes WHERE ciudad = (SELECT MAX(ciudad) FROM concesionario);

/* 13.- Obtener el nombre y el modelo de los coches vendidos por algún concesionario de 'BARCELONA'. */
SELECT nombre, modelo FROM coches WHERE codcoche IN (SELECT codcoche FROM ventas WHERE cifc IN (SELECT cifc FROM concesionario WHERE ciudad like 'Barcelona'));

/* 14.- Obtener todos los nombres y apellidos de los clientes que hayan adquirido algún coche del concesionario 'DCAR'. */
SELECT nombre, apellidos FROM clientes WHERE dni IN (SELECT dni FROM ventas WHERE cifc IN (SELECT cifc FROM concesionario WHERE nombre like 'DCAR'));

/* 15.- Obtener el NOMBRE y el APELLIDO de los clientes que han adquirido un coche modelo 'GTI' de color 'BLANCO'. */
SELECT nombre, apellidos FROM clientes WHERE dni IN (SELECT dni FROM ventas WHERE codcoche IN (SELECT codcoche FROM coches WHERE modelo like 'GTI') AND color like 'Blanco');

/* 16.- Obtener el codcoche de los coches que han sido adquiridos por un cliente de 'MADRID' a un concesionario de 'MADRID'.*/
SELECT codcoche FROM ventas WHERE dni IN (SELECT dni FROM clientes WHERE ciudad like 'MADRID') AND cifc IN (SELECT cifc FROM concesionario WHERE ciudad like 'Madrid');

/* 17.- Obtener el dni, nombre, apellido y ciudad de los clientes que han adquirido un automóvil a un concesionario que posea actualmente coches en stock del modelo 'GTI'. */
SELECT * FROM clientes WHERE dni IN (SELECT dni FROM ventas WHERE cifc IN (SELECT cifc FROM distribucion WHERE cantidad > 0 AND codcoche IN (SELECT codcoche FROM coches WHERE modelo like 'GTI')));

/* 18.- Obtener el nombre, apellido y ciudad de los clientes que han adquirido un automóvil a un concesionario de 'MADRID' que posea actualmente coches en stock del modelo 'GTI'. */
SELECT nombre, apellidos, ciudad FROM clientes WHERE dni IN (SELECT dni FROM ventas WHERE cifc IN (SELECT cifc FROM concesionario WHERE ciudad like 'Madrid') AND cifc IN (SELECT cifc FROM distribucion WHERE cantidad > 0 AND codcoche IN (SELECT codcoche FROM coches WHERE modelo like 'GTI')));

/* 19.- Obtener el cifc y nombre del concesionario que no sea de 'MADRID' cuya media de vehículos en stock sea la mas alta de todas las medias. */
SELECT cifc, nombre FROM concesionario WHERE ciudad <> 'Madrid' AND cifc IN (SELECT cifc FROM distribucion GROUP BY cifc HAVING AVG(cantidad) >= ALL (SELECT AVG(cantidad) FROM distribucion GROUP BY cifc));

/* 20.- Obtener los nombres de los clientes que no han comprado ningún coche 'ROJO' a ningún concesionario de 'MADRID'. */
SELECT nombre FROM clientes WHERE NOT dni IN (SELECT dni FROM ventas WHERE color like 'Rojo' AND cifc IN (SELECT cifc FROM concesionario WHERE ciudad like 'Madrid'));



SELECT nombre, apellidos FROM clientes c INNER JOIN ventas v1 ON c.dni=v1.dni INNER JOIN ventas v2 ON c.dni=v2.dni AND v1.color like 'Blanco' AND v2.color like 'Rojo';