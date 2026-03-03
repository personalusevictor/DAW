/* 1.- Pasadas las fiestas navideñas Talleres Faber quiere enviar publicidad a sus clientes. Para ello quiere seleccionar a aquellos a los que no se les ha emitido ninguna factura desde el 6 de Enero. Obtener un listado con Nombre, Apellidos y Dirección de esos clientes. */
SELECT c.nombre, c.apellidos, c.direccion FROM clientes c WHERE codcliente NOT IN (SELECT f.codcliente FROM facturas f WHERE day(FechaFactura) >= 6 AND month(FechaFactura) >= 1);

/* 2.- El gerente quiere conocer los apellidos y el nombre del empleado que más horas ha trabajado. La consulta debe mostrar 2 columnas:

    Los apellidos y el nombre, separados por una coma y un espacio con el encabezado ‘Apellidos y nombre’
    Las horas totales trabajadas, con el encabezado ‘Horas totales trabajadas’
*/
SELECT CONCAT(e.apellidos, ", ", e.nombre) AS "Apellidos y nombre", SUM(i.horas) AS "Horas totales trabajadas" FROM empleados e INNER JOIN intervienen i ON e.CodEmpleado LIKE i.CodEmpleado GROUP BY i.CodEmpleado, e.apellidos, e.nombre ORDER BY SUM(i.horas) DESC LIMIT 1;

/* 3.- ¿Cuál es?

    Importe total de los recambios: PrecioReferencia*Unidades
    Importe total de las actuaciones: Horas*50 */
SELECT SUM(r.PrecioReferencia*i.Unidades) AS "Importe Recambios" FROM recambios r INNER JOIN incluyen i ON r.IdRecambio LIKE i.IdRecambio;
SELECT SUM(r.horas*50) AS "Horas Totales" FROM realizan r;

/* 4.- Obtener un listado con el número de reparaciones en las que ha intervenido cada uno de los empleados. El listado debe mostrar:

    El número de reparaciones, los apellidos y el nombre del empleado.
    El número de reparaciones debe aparecer en orden descendente. */
SELECT COUNT(i.idReparacion) AS "Numero Reparaciones", e.apellidos, e.nombre FROM intervienen i INNER JOIN empleados e ON i.CodEmpleado like e.CodEmpleado GROUP BY i.CodEmpleado, e.apellidos, e.nombre ORDER BY 1 DESC;

/* 5.- Los socios del taller pretenden dar un servicio cada vez más rápido a sus clientes. Para ello han previsto que las reparaciones se realicen antes de 2 días. Interesa conocer las reparaciones que han superado esa previsión y los empleados que la han realizado. Las columnas que se deben mostrar son:

    Nombre de los empleados, Fecha de entrada, Fecha de salida y Fecha de salida prevista (2 días a partir de la fecha de entrada).
    Combinar las tablas utilizando la Combinación interna (INNER JOIN). */
SELECT e.nombre AS "Nombre del empleado", r.fechaentrada AS "Fecha de entrada", r.fechasalida AS "Fecha de salida", DATE(r.fechaentrada + 2) AS "Salida Prevista" FROM intervienen i INNER JOIN empleados e ON i.CodEmpleado = e.CodEmpleado INNER JOIN reparaciones r ON i.IdReparacion = r.IdReparacion WHERE r.fechasalida > DATE(r.fechaentrada + 2);

/*  6.- Hacer una consulta que devuelva los nombres y categorías de los empleados que han intervenido en alguna reparación. */
SELECT DISTINCT e.nombre, e.categoria FROM intervienen i INNER JOIN empleados e ON i.CodEmpleado like e.CodEmpleado INNER JOIN reparaciones r ON i.IdReparacion like r.IdReparacion WHERE r.IdReparacion > 1;

/*  7.- . Interesa conocer cuál es el vehículo con más kilómetros que ha visitado el taller. Mostrar los kilómetros, la marca, el modelo, el color y la matrícula. */
SELECT v.matricula, r.km, v.marca, v.modelo, v.color FROM vehiculos v INNER JOIN reparaciones r ON v.Matricula like r.Matricula ORDER BY r.km DESC LIMIT 1;

/* 8.- En Talleres Faber están pensando en hacer más rentable la gestión de los recambios. Se pretende optimizar el stock, para ello se solicita un listado con los siguientes datos: 
IdRecambio, Descripción, UnidadBase y Stock, de los artículos que superen el stock considerado como óptimo, según los siguientes criterios:

    Para los artículos cuya unidad base se mide como una unidad se considera el stock óptimo hasta 10 artículos.
    Para los artículos cuya unidad base no sea una unidad el stock considerado como óptimo es hasta 4 artículos.
*/
SELECT re.IdRecambio, re.Descripcion, re.UnidadBase FROM recambios re WHERE re.Stock <= 10;
SELECT re.IdRecambio, re.Descripcion, re.UnidadBase FROM recambios re WHERE re.Stock <= 4;

/* 9.- Con relación a las actuaciones, se considera importante saber cuántas reparaciones se realizan de importe superior a la media. La consulta nos devolverá un solo dato: el número de reparaciones realizadas cuyo importe supera el importe medio de las actuaciones. */
SELECT COUNT(r.IdReparacion) AS "Nº de Reparaciones Superior a la Media" FROM realizan r INNER JOIN actuaciones a ON r.Referencia like a.Referencia WHERE importe > (SELECT AVG(importe) FROM actuaciones);

/* 10.- Obtener un listado que nos informe del número de facturas que hemos emitido a cada cliente. El listado tendrá dos columnas: el nombre completo del cliente y el número de facturas que le corresponden. */
SELECT CONCAT(c.Apellidos, ", ",c.Nombre), COUNT(f.IdFactura) "Número de facturas" FROM clientes c INNER JOIN facturas f ON c.CodCliente like f.CodCliente GROUP BY c.CodCliente ORDER BY COUNT(f.IdFactura) DESC;

/* 11.- Obtener una lista de reparaciones junto con el nombre del cliente y el empleado que trabajó en la reparación, entre el 5 y 10 de enero. En caso el coche siga en taller que ponga 'Sin Reparar' en fecha de salida (usa left join).*/
SELECT r.IdReparacion, c.Nombre as Cliente, e.Nombre as Empleado, r.Avería, r.FechaEntrada, ifnull(r.FechaSalida, "Sin Reparar") "Fecha Salida" FROM reparaciones r
	LEFT JOIN vehiculos v ON v.Matricula like r.Matricula
    LEFT JOIN clientes c ON v.CodCliente like c.CodCliente
    LEFT JOIN intervienen i ON r.IdReparacion like i.IdReparacion
    LEFT JOIN empleados e ON i.CodEmpleado like e.CodEmpleado
    WHERE r.FechaEntrada BETWEEN '2011-01-05' AND '2011-01-10';