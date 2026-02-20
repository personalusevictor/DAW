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