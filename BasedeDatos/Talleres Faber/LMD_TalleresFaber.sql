/* 1.- Pasadas las fiestas navideñas Talleres Faber quiere enviar publicidad a sus clientes. Para ello quiere seleccionar a aquellos a los que no se les ha emitido ninguna factura desde el 6 de Enero. Obtener un listado con Nombre, Apellidos y Dirección de esos clientes. */
SELECT c.nombre, c.apellidos, c.direccion FROM clientes c WHERE codcliente NOT IN (SELECT f.codcliente FROM facturas f WHERE day(FechaFactura) >= 6 AND month(FechaFactura) >= 1);

