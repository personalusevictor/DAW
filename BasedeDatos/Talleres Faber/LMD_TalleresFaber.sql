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
SELECT COUNT(i.idReparacion) AS "Numero Reparaciones", e.apellidos, e.nombre FROM intervienen i INNER JOIN empleados e ON i.CodEmpleado like e.CodEmpleado GROUP BY i.CodEmpleado, e.apellidos, e.nombre ORDER BY COUNT(i.IdReparacion) ASC;

/* 5.- Los socios del taller pretenden dar un servicio cada vez más rápido a sus clientes. Para ello han previsto que las reparaciones se realicen antes de 2 días. Interesa conocer las reparaciones que han superado esa previsión y los empleados que la han realizado. Las columnas que se deben mostrar son:

    Nombre de los empleados, Fecha de entrada, Fecha de salida y Fecha de salida prevista (2 días a partir de la fecha de entrada).
    Combinar las tablas utilizando la Combinación interna (INNER JOIN). */