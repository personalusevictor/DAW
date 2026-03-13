/* 1.- Código y nombre de todos los departamentos, ordenados alfabéticamente.*/
SELECT d.codigo, d.nombre FROM departamentos d ORDER BY d.nombre ASC;

/* 2.- Mes y ejercicio de los justificantes de nómina pertenecientes al empleado 'José Luis Pérez'.*/
SELECT j.mes, j.ejercicio FROM just_nominas j 
	INNER JOIN empleados e ON j.cod_emp like e.codigo 
WHERE e.nombre like 'José Luis Pérez';

/* 3.- Número de cuenta y nombre de los empleados cuya retención es mayor o igual que 10. */
SELECT e.cuenta, e.nombre FROM empleados e WHERE e.retencion >= 10;

/* 4.- Código y nombre de los empleados que trabajan en el departamento de ventas, ordenados ascendentemente por nombre. */
SELECT e.codigo, e.nombre FROM trabajan t
	INNER JOIN empleados e ON t.cod_emp like e.codigo 
    INNER JOIN departamentos d ON t.cod_dep like d.codigo 
WHERE d.nombre like 'Ventas' ORDER BY e.nombre ASC;

/* 5.- Nombre de los administrativos que tienen más de 2 hijos. */
SELECT e.nombre FROM trabajan t 
	INNER JOIN empleados e ON t.cod_emp like e.codigo 
WHERE t.funcion like 'Administrativo' AND e.hijos > 2;

/* 6.- Nombre y número de cuenta de los empleados cuyo nombre empieze por 'A' o por 'J'.*/
SELECT e.nombre, e.cuenta FROM empleados e WHERE e.nombre like 'A%' OR e.nombre like 'J%';

/* 7.- Número de vendedores que tiene la empresa. */
SELECT COUNT(t.funcion) 'Nº Vendedores' FROM trabajan t WHERE t.funcion like 'Vendedor';

/* 8.- Nombre del primer y último empleado en términos alfabéticos. */
(SELECT e.nombre FROM empleados e ORDER BY e.nombre ASC LIMIT 1)
UNION
(SELECT e.nombre FROM empleados e ORDER BY e.nombre DESC LIMIT 1);

/* 9.- Nombre y número de hijos de los empleados cuya retención es: 8, 10 o 12. */
SELECT e.nombre, e.hijos FROM empleados e WHERE e.retencion IN (8, 10, 12);

/* 10.- Número de hijos y número de empleados que tienen 0,1,2, 3,... hijos, mostrando sólo los grupos cuyos empleados tengan algún hijo. Sale que hay 4 empleados que tienen 1 hijo, 1 empleado con 2 hijos y 3 empleados tienen 3 hijos. */
SELECT e.hijos, COUNT(e.codigo) FROM empleados e WHERE e.hijos > 0 GROUP BY e.hijos ORDER BY e.hijos ASC;

/* 11.- Número de hijos, retención máxima, mínima y media de los empleados agrupados por hijos. */
SELECT e.hijos, MAX(e.retencion), MIN(e.retencion), AVG(e.retencion) FROM empleados e 
GROUP BY e.hijos ORDER BY e.hijos ASC;

/* 12.- Nombre y función de los empleados que han trabajado en el departamento de Marketing. */
SELECT e.nombre, t.funcion FROM trabajan t 
	INNER JOIN empleados e ON t.cod_emp like e.codigo 
	INNER JOIN departamentos d ON t.cod_dep like d.codigo
WHERE d.nombre like 'Marketing';

/* 13.- Nombre del empleado, nombre del departamento y función que han realizado de los empleados que tienen 1 hijo. */
SELECT e.nombre, d.nombre, t.funcion FROM trabajan t 
	INNER JOIN empleados e ON t.cod_emp like e.codigo 
    INNER JOIN departamentos d ON t.cod_dep like d.codigo 
WHERE e.hijos like 1;

/* 14.- Nombre de los empleado que ha trabajado en el departamento de 'Recursos Humanos' que tienen entre 1 y 3 hijos.*/
SELECT e.nombre, d.nombre, e.hijos FROM trabajan t 
	INNER JOIN empleados e ON t.cod_emp like e.codigo 
    INNER JOIN departamentos d ON t.cod_dep like d.codigo 
WHERE d.nombre like 'Recursos Humanos' AND e.hijos BETWEEN 1 AND 3;

/* 15.- Nombre del empleado, mes y ejercicio de sus justificantes de nómina, número de línea y cantidad de las líneas de los justificantes para la empleada 'Encarna López López'. */
SELECT DISTINCT e.nombre, j.mes, j.ejercicio, l.numero, l.cantidad FROM just_nominas j 
	INNER JOIN empleados e ON j.cod_emp like e.codigo 
	INNER JOIN lineas l ON j.cod_emp like l.cod_emp AND j.mes like l.mes AND j.ejercicio like l.ejercicio
WHERE e.nombre like 'Encarna Lopéz López' ORDER BY e.nombre, j.mes, j.ejercicio, l.numero, l.cantidad;

/* 16.- Nombre del empleado, mes y ejercicio de sus justificantes de nómina para los empleados que han trabajado en el departamento de Dirección. */
SELECT e.nombre, j.mes, j.ejercicio FROM empleados e
	INNER JOIN just_nominas j ON e.codigo like j.cod_emp
    INNER JOIN trabajan t ON e.codigo like t.cod_emp
    INNER JOIN departamentos d ON t.cod_dep like d.codigo
WHERE d.nombre = 'Dirección';

/* 17.- Quiero saber el sueldo neto (sueldo bruto - descuento para impuestos) de cada empleado. */
SELECT e.nombre, sum(j.ingreso - j.descuento) 'Sueldo Neto' FROM empleados e
	INNER JOIN just_nominas j ON e.codigo like j.cod_emp
GROUP BY e.codigo ORDER BY e.nombre;

/* 18.- Nombre de los empleados que han ganado más de 2000 € en el año 2006. */
SELECT e.nombre, sum(j.ingreso - j.descuento) 'Sueldo Neto' FROM empleados e 
	INNER JOIN just_nominas j ON e.codigo like j.cod_emp
WHERE j.ejercicio = 2006 GROUP BY e.codigo HAVING sum(j.ingreso - j.descuento) > 2000;

/* 19.- Número de empleados cuyo número de hijos es superior a la media de hijos de los empleados. */
SELECT COUNT(e.codigo) 'Nº Empleados' FROM empleados e WHERE e.hijos > (SELECT AVG(e.hijos) FROM empleados e);

/* 20.- Nombre de los empleados que más hijos tienen o que menos hijos tienen. */
SELECT e.nombre, e.hijos FROM empleados e WHERE e.hijos IN (SELECT MIN(e.hijos) FROM empleados e) OR e.hijos IN (SELECT MAX(e.hijos) FROM empleados e);

/* 21.- Nombre de los empleados que no tienen justificante de nóminas.*/
SELECT e.nombre FROM empleados e WHERE e.codigo NOT IN (SELECT cod_emp FROM just_nominas);

/* 22.- Nombre y fecha de nacimiento de todos los empleados (formato corto y largo). */
SELECT e.nombre, 
date_format(e.fnacimiento, '%d / %m / %Y') 'Fecha de Nacimiento Corto', e.fnacimiento 'Fecha de Nacimiento Largo' 
FROM empleados e;

/* 23.- Nombre, edad y número de hijos de los empleados que tienen más de 50 años y tienen hijos. */
SELECT e.nombre, 
timestampdiff(year, e.fnacimiento, current_date()) 'Edad', e.hijos 
FROM empleados e 
WHERE timestampdiff(year, e.fnacimiento, current_date()) > 50 AND e.hijos > 0;

/* 24.- Nombre, edad de los empleados y nombre del departamento de los empleados que han trabajado en más de un 
departamento. */
SELECT e.nombre, timestampdiff(year, e.fnacimiento, current_date()) 'Edad', d.nombre FROM trabajan t
INNER JOIN empleados e ON e.codigo like t.cod_emp
INNER JOIN departamentos d ON d.codigo like t.cod_dep
WHERE e.codigo IN (SELECT t.cod_emp FROM trabajan t GROUP BY t.cod_emp HAVING COUNT(t.cod_dep) > 1);