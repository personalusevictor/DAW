/* 1. Listado con el código, nombre, fecha de inscripción y cuota de los concursantes masculinos con cuota_inscri entre 50 y 100 euros (icluidos límites), año de inscripción 2019 y mes entre marzo y septiembre (incluidos). Utiliza la función year() y month() para ello. Ordena el resultado de mayor a menor cuota. El encabezado debe ser 'codigo, jugador, fecha, cuota.
Haz dos versiones:

	a) Usando BETWEEN donde sea posible
	b) Sin usar BETWEEN. */
    
-- a)
SELECT cdconcur AS 'código', nombre, fecha_inscri AS 'fecha', cuota_inscri AS 'cuota' FROM concursante 
WHERE sexo like 'M' 
AND cuota_inscri BETWEEN 50 AND 100 
AND 2019 = year(fecha_inscri)
AND month(fecha_inscri) BETWEEN 03 AND 09;

-- b)
SELECT cdconcur AS codigo, nombre, fecha_inscri AS fecha, cuota_inscri AS cuota FROM concursante 
WHERE sexo like 'M' 
AND cuota_inscri >= 50 AND cuota_inscri <= 100 
AND 2019 = year(fecha_inscri)
AND month(fecha_inscri) >= 03 AND month(fecha_inscri) <= 09;

/* 2.-  Listado con el código, nombre, comunidad y año de fundación de los equipos de concursantes que son de Andalucía, Murcia o Galicia y su año de fundación es el 2019. Ordena por comunidad alfabéticamente.
Redacta dos versiones:
	a)Usando IN() donde sea posible 
    b) Sin usar IN(). */

-- a)
SELECT cdequipo AS 'código', nombre, comunidad, anio_funda AS 'año de fundación' FROM equipo
WHERE comunidad IN('Andalucia');

-- b)
SELECT cdequipo AS 'código', nombre, comunidad, anio_funda AS 'año de fundación' FROM equipo
WHERE comunidad like 'Andalucia';

/* 3.- Listado con el código, nombre, dificultad y megusta del o los juegos con mas megusta. (Con subconsulta). */
SELECT cdjuego AS 'código', nombre, dificultad, megusta FROM juego WHERE megusta IN (SELECT MAX(megusta) FROM juego);

/* 4.- Listado con todos los datos de los juegos sin valor (valor nulo) en megusta y nombre de su equipo organizador. */
SELECT * FROM juego j INNER JOIN equipo e WHERE megusta IS NULL AND j.cdequipo = e.cdequipo AND e.nombre IS NULL;

/* 5.- Listado con el nombre, dificultad, megusta y código de equipo de los juegos  organizados por el mismo equipo que el del juego de nombre 'Elvenar'. (Con subconsulta) */
SELECT nombre, dificultad, megusta, cdequipo AS 'código de equipo' FROM juego WHERE cdjuego IN (SELECT cdjuego FROM juego WHERE nombre like 'Elvenar');

/*6.- Modifica la consulta 5. para que también se muestre el nombre y comunidad del equipo.*/
SELECT j.nombre, j.dificultad, j.megusta, j.cdequipo  AS 'código de equipo', e.nombre, e.comunidad FROM juego j INNER JOIN equipo e ON j.cdequipo like e.cdequipo WHERE j.cdjuego IN (SELECT cdjuego FROM juego WHERE nombre like 'Elvenar');

/* 7.- Para los concursantes que participan en juegos, listar el código y nombre de concursantes y código del juego en el que participan, mostrando los puntos y fecha de inicio. Ordena el listado alfabéticamente por código de concursante.*/
SELECT c.cdconcur, c.nombre, p.cdjuego, p.puntos, p.fecha_inicio FROM concursante c JOIN participa p ON c.cdconcur like p.cdconcur ORDER BY c.cdconcur ASC;

/* 8.- Lista donde aparezcan los códigos y nombre de todos los concursantes, nombre de sus equipos y nombre de los juegos en los que participan, así como los puntos que llevan en cada juego. Los concursantes que no participan en juegos aparecerán también en la lista y en el lugar del juego aparecerá “sin juego” y en horas un cero. Debes poner un encabezado apropiado de manera que no aparezcan nulos en el listado.*/
SELECT c.cdconcur, c.nombre, ifnull(e.nombre, "sin equipo") 'equipo', ifnull(j.nombre, "sin juego") 'juego', ifnull(p.puntos, 0) 'puntos', ifnull(p.fecha_inicio, "sin fecha") 'fecha' FROM concursante c LEFT JOIN equipo e ON c.cdequipo like e.cdequipo LEFT JOIN participa p ON c.cdconcur like p.cdconcur LEFT JOIN juego j ON p.cdjuego like j.cdjuego;

/* 9.- Para cada concursante que participa en juegos, su código, nombre y la media de sus puntos. Redondear la media de puntos con dos decimales, (usa la función ROUND()) y ordenar de más a menos puntos.*/
SELECT c.cdconcur, c.nombre, ROUND(AVG(p.puntos), 2) AS media_puntos FROM concursante c INNER JOIN participa p ON c.cdconcur = p.cdconcur GROUP BY c.cdconcur, c.nombre ORDER BY media_puntos DESC;

/* 10.- Modifica la consulta 9. para que aparezca el código y nombre del ídolo de cada concursante. Limita el listado a los 5 concursantes con la media más alta.*/
SELECT c.cdconcur, c.nombre, ROUND(AVG(p.puntos), 2) AS media_puntos, i.cdconcur, i.nombre FROM concursante c INNER JOIN participa p ON c.cdconcur = p.cdconcur INNER JOIN concursante i ON c.cdidolo like i.cdconcur GROUP BY c.cdconcur, c.nombre, i.cdconcur, i.nombre ORDER BY media_puntos DESC;

/* 11.- Listado de los nombres de juegos en los que aparezca la palabra “Empire”, indicando los megusta que tiene, dificultad y  total de concursantes que participan en el juego. */
SELECT j.nombre, IFNULL(j.megusta, 0) AS "Me gusta", j.dificultad, COUNT(p.cdconcur) AS "Nº Concursantes" FROM juego j INNER JOIN participa p ON j.cdjuego like p.cdjuego WHERE j.nombre LIKE '%Empire%' GROUP BY j.cdjuego, j.nombre, j.megusta, j.dificultad;

/* 12.- Listado con el código de juego y total de concursantes que participan en cada juego. En el listado mostrar solo los juegos en los que participan 2 o más concursantes. Ordenar de más  menos paticipación.*/
SELECT p.cdjuego, COUNT(p.cdconcur) AS "cuenta" FROM participa p GROUP BY p.cdjuego HAVING COUNT(cdconcur) >= 2 ORDER BY 2 DESC;