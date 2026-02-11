/* 1.- Obtener todos los campos de todos los concesionarios.*/
select * from concesionario;

/* 2.-  Obtener todos los campos de todos los clientes de 'MADRID'.*/
select * from clientes where ciudad = 'MADRID';

/* 3.- Obtener los nombres de todas las MARCAS de coches ordenadas alfabéticamente. */
select nombre from marcas order by nombre;

/* 4.- Obtener el cifc de todos los concesionarios cuya cantidad en la tabla de DISTRIBUCION es mayor que 18. */
select cifc from distribucion where cantidad > 18;

/* 5.- Obtener el cifc de todos los concesionarios cuya cantidad en la tabla de DISTRIBUCION está comprendida entre 
10 y 18 ambos inclusive.*/
select cifc from distribucion where cantidad between 10 and 18;

/* 6.- Obtener el cifc de todos los concesionarios cuya cantidad en la tabla de DISTRIBUCION está comprendida entre 
10 y 18, ambos inclusive. (De otra manera) */
select cifc from distribucion where cantidad >= 10 and cantidad<=18;

/* 7.- Obtener el cifc de todos los concesionarios que han adquirido más de 10 coches o menos de 5. */
select cifc from distribucion where cantidad > 10 OR cantidad < 5;

/* 8.- Obtener todos los codcoche de los coches cuyo nombre empiece por ‘C’. */
select codcoche, nombre from coches where nombre like "C%";

/* 9.- Obtener todos los codcoche de los coches cuyo nombre no contiene ninguna ‘A’. */
select codcoche, nombre from coches where nombre not like "%A%";

/* 10.- Obtener el cifc de todos los concesionarios cuyo número de coches en stock no es nulo. */
select cifc from concesionario where cifc is not null;

/* 11.- Obtener el cifm y el nombre de las marcas de coches cuya segunda letra del nombre de la ciudad de origen 
sea una 'I’. */
select cifm, nombre from marcas where ciudad like "_I%";

/* 12.- Aumentar en 5 coches a la cantidad en distribución de los concesionarios que tienen en stock coches con el 
código 6. */
select cifc, codcoche, cantidad, cantidad + 5 as "Nueva Cantidad" from distribucion where codcoche = 6;