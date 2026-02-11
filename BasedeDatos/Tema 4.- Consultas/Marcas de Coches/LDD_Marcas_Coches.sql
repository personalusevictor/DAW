CREATE DATABASE marcas_de_coches;

USE marcas_de_coches;

CREATE TABLE marcas (
    cifm INT,
    nombre VARCHAR(15),
    ciudad VARCHAR(20),
    CONSTRAINT cifm_mar_pk PRIMARY KEY (cifm)
);

CREATE TABLE coches (
    codcoche INT,
    nombre VARCHAR(15),
    modelo VARCHAR(15),
    cifm INT,
    CONSTRAINT cod_coc_pk PRIMARY KEY (codcoche),
    CONSTRAINT cifm_coc_fk FOREIGN KEY (cifm) REFERENCES marcas (cifm)
);

CREATE TABLE concesionario (
    cifc INT,
    nombre VARCHAR(15),
    ciudad VARCHAR(20),
    CONSTRAINT cifc_con_pk PRIMARY KEY (cifc)
);

CREATE TABLE clientes (
    dni VARCHAR(9),
    nombre VARCHAR(15),
    apellidos VARCHAR(30),
    ciudad VARCHAR(20),
    CONSTRAINT dni_cli_pk PRIMARY KEY (dni)
);

CREATE TABLE distribucion (
    cifc INT,
    codcoche INT,
    cantidad INT,
    CONSTRAINT dis_pk PRIMARY KEY (cifc , codcoche),
    CONSTRAINT cifc_dis_fk FOREIGN KEY (cifc) REFERENCES concesionario (cifc),
    CONSTRAINT cod_dis_fk FOREIGN KEY (codcoche) REFERENCES coches (codcoche)
);

CREATE TABLE ventas (
    cifc INT,
    dni VARCHAR(9),
    codcoche INT,
    color VARCHAR(10),
    CONSTRAINT dis_pk PRIMARY KEY (cifc , codcoche , dni),
    CONSTRAINT cifc_ven_fk FOREIGN KEY (cifc) REFERENCES concesionario (cifc),
    CONSTRAINT cod_ven_fk FOREIGN KEY (codcoche) REFERENCES coches (codcoche)
);