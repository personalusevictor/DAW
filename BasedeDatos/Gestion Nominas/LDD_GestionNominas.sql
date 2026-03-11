create database gestion_nominas;
use gestion_nominas;

create table Empleados (
	codigo decimal(5,0),
	nombre varchar(30) not null,
  fnacimiento date,
	hijos decimal(2,0) not null,
	retencion decimal(2,0) not null,
	cuenta char(20) not null unique,
	primary key (codigo)
);
    
create table Departamentos (
	codigo decimal(5,0),
	nombre varchar(20) not null unique,
	primary key (codigo)
);
    
create table Trabajan (
	cod_emp decimal(5,0),
	cod_dep decimal(5,0),
	funcion varchar(30) not null,
	primary key (cod_emp, cod_dep),
	foreign key (cod_emp) references Empleados(codigo),
	foreign key (cod_dep) references Departamentos(codigo)
);
    
create table Just_nominas (
	mes decimal(2,0),
	ejercicio decimal(4,0),
	ingreso decimal(8,0) not null,
	descuento decimal(8,0) not null,
	cod_emp decimal(5,0),
	primary key (mes, ejercicio, cod_emp),
	foreign key (cod_emp) references Empleados(codigo)
);
    
create table Lineas (
	numero decimal(5,0),
	cantidad decimal(8,0) not null,
	base decimal(8,0),
	porcentaje decimal(2,0),
	mes decimal(2,0),
	ejercicio decimal(4,0),
	cod_emp decimal(5,0),
	primary key (numero, mes, ejercicio, cod_emp),
	foreign key (mes, ejercicio, cod_emp) references Just_nominas(mes, ejercicio, cod_emp)
);