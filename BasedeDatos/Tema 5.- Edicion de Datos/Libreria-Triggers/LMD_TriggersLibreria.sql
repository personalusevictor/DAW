-- 1. Crear un disparador que salte cuando se produce una venta de un libro para disminuir el stock del mismo.
DELIMITER //

CREATE TRIGGER trg_restar_stock_venta
AFTER INSERT ON ventas
FOR EACH ROW
BEGIN
    UPDATE libros
    SET stock = stock - NEW.cantidad
    WHERE codigo = NEW.codigolibro;
END //

DELIMITER ;

/* 2. Creamos un nuevo disparador para actualizar el campo "stock" de la tabla "libros" cuando se elimina un registro de la tabla "ventas" 
(por ejemplo, si el comprador devuelve todos los libros comprados) */

DELIMITER //
CREATE TRIGGER trg_devolver_stock_delete
AFTER DELETE ON ventas
FOR EACH ROW
BEGIN
    UPDATE libros
    SET stock = stock + OLD.cantidad
    WHERE codigo = OLD.codigolibro;
END //

DELIMITER ;

/* 3. Creamos un nuevo disparador para actualizar el campo "stock" de la tabla "libros" cuando se actualiza un registro de la tabla "ventas" 
(por ejemplo, el cliente devuelve algún libro, no todos los que compró) */

DELIMITER //

CREATE TRIGGER trg_devolucion_parcial
AFTER UPDATE ON ventas
FOR EACH ROW
BEGIN
    -- Si baja la cantidad vendida, se devuelve stock
    IF NEW.cantidad < OLD.cantidad THEN
        UPDATE libros
        SET stock = stock + (OLD.cantidad - NEW.cantidad)
        WHERE codigo = NEW.codigolibro;

    -- Si aumenta (caso raro), se descuenta stock
    ELSEIF NEW.cantidad > OLD.cantidad THEN
        UPDATE libros
        SET stock = stock - (NEW.cantidad - OLD.cantidad)
        WHERE codigo = NEW.codigolibro;
    END IF;
END //

DELIMITER ;

/* 4. Crear un trigger que actualice automáticamente el precio de los libros. El trigger comprobará si el precio del libro ha cambiado y, en caso 
afirmativo, establecerá el nuevo precio aumentando el 10% de ganancias en la venta. */

DELIMITER //

CREATE TRIGGER trg_actualizar_precio
BEFORE UPDATE ON libros
FOR EACH ROW
BEGIN
    -- Si el precio cambia
    IF NEW.precio <> OLD.precio THEN
        SET NEW.precio = NEW.precio * 1.10;
    END IF;
END //

DELIMITER ;