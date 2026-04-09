
create database centro_enseñanaza;

use centro_enseñanaza;

CREATE TABLE PROFESORADO
( Codigo int, 
  Nombre VARCHAR(30), 
  Apellidos VARCHAR(30), 
  DNI VARCHAR(10), 
  Especialidad VARCHAR(20),
  Fecha_Nac DATE,
  Antiguedad int,
  PRIMARY KEY (Codigo)
);  

CREATE TABLE CURSOS
( Codigo int, 
  Nombre VARCHAR(20), 
  Cod_Profe int, 
  Max_Alumn int, 
  Fecha_Inic DATE, 
  Fecha_Fin DATE, 
  Num_Horas int,
  PRIMARY KEY (Codigo),    
 FOREIGN KEY (Cod_Profe) REFERENCES PROFESORADO(Codigo)
);
                    
CREATE TABLE ALUMNADO_NUEVO
( Nombre VARCHAR(30), 
  Apellidos VARCHAR(30), 
  Sexo VARCHAR(1), 
  Fecha_Nac DATE
);
              
CREATE TABLE ALUMNADO
( Codigo int auto_increment, 
  Nombre VARCHAR(30), 
  Apellidos VARCHAR(30), 
  Sexo VARCHAR(1), 
  Fecha_Nac DATE, 
  Cod_Curso int,
  PRIMARY KEY (Codigo),    
  FOREIGN KEY (Cod_Curso) REFERENCES CURSOS(Codigo)
);
   
   
   
/*Datos*/


INSERT INTO CURSOS (Codigo, Nombre, Max_Alumn, Fecha_Inic, Fecha_Fin, Num_Horas) VALUES 
(1, 'Curso 1', 30, '2011-01-01', '2011-12-31', 100);
INSERT INTO CURSOS (Codigo, Nombre, Max_Alumn, Fecha_Inic, Fecha_Fin, Num_Horas) VALUES 
(2, 'Curso 2', 30, '2011-01-01', '2011-12-31', 100);
INSERT INTO CURSOS (Codigo, Nombre, Max_Alumn, Fecha_Inic, Fecha_Fin, Num_Horas) VALUES 
(3, 'Curso 3', 30, '2011-01-01', '2011-12-31', 100);
INSERT INTO CURSOS (Codigo, Nombre, Max_Alumn, Fecha_Inic, Fecha_Fin, Num_Horas) VALUES 
(4, 'Curso 4', 30, '2011-01-01', '2011-12-31', 100);
INSERT INTO CURSOS (Codigo, Nombre, Max_Alumn, Fecha_Inic, Fecha_Fin, Num_Horas) VALUES 
(5, 'Curso 5', 30, '2011-01-01', '2011-12-31', 100);
INSERT INTO CURSOS (Codigo, Nombre, Max_Alumn, Fecha_Inic, Fecha_Fin, Num_Horas) VALUES 
(6, 'Curso 6', 30, '2011-01-01', '2011-12-31', 100);
   
    
    
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MANUELA','SUAREZ IBAÑEZ','M','1990-6-30',1);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MILAGROSA','DIAZ PEREZ','M','1984-10-28',3);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JOSE','CRESPO DE HERMOSO','H','1993-3-2',1);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('ANTONIO JESUS','MARTIN BOLLO','H','1999-11-4',1);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('BARBARA','PELAEZ VALENCIA','M','1967-8-27',4);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JUAN PEDRO','GALVE GONZALEZ','H','1991-11-10',4);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MARIA ISABEL','PEREZ GUILLEN','M','1962-11-14',2);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('PATRICIA','ROMAN GOMEZ','M','1979-4-26',3);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('DAVID','TAPIA SOLANS','H','1980-6-5',4);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MARIA','FERREIRO SANTOS','M','1969-1-29',1);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JAVIER','LAMA DEL REY','H','1977-2-26',2);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('ALEJANDRA','CALDERON VALDIVIA','M','1960-11-16',2);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('ANA DOLORES','ESCUDERO ENCISO','M','1975-9-7',4);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JUAN CARLOS','RODRIGUEZ PADILLA','H','1963-11-15',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('CECILIO','SASTRE GONZALEZ','H','1969-11-23',3);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JUAN','MARTINEZ SANCHEZ','H','1974-10-23',2);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MARIA','LAFUENTE FERNANDEZ','M','1986-11-21',2);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MANUELA','MARTINEZ ALBA','M','1962-11-26',1);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('ROSA NIEVES','SANCHEZ CANO','M','1979-12-12',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('BELEN','RAMOS ANGUITA','M','1967-12-30',2);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JULIAN','GARCIA ZABALA','H','1963-1-4',3);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('DIEGO JESUS','CANO SALVADOR','H','1970-5-18',1);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JOSE IGNACIO','HARO FANECA','H','1981-5-8',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JOSEFA','CASTELLANOS DIEZ','M','1998-5-1',2);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('BEATRIZ','RUBIO BERMEJO','M','1970-5-29',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JAVIER','CASTRO GOMEZ','H','1967-8-20',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('DAVID','GAY GARCIA DEL VALLE','H','1989-7-22',3);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('DAVID','TOCADOS GARCIA','H','1961-1-18',1);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('ELISA ISABEL','BRUNO CALVO','M','1998-3-16',4);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('DIANA','GUILLAMON POSADA','M','1980-6-18',2);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('DAVID','RANILLA URRUTIA','H','1964-1-18',2);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JAVIER','LUENGO HERRERO','H','1963-3-28',3);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('DAVID','VALENCIA MEDINA','H','1972-12-15',2);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('RAFAEL','DIAZ LAMA','H','1979-1-6',1);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('CAROLINA','RIVAS MENDIA','M','1974-2-1',1);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JOSE MANUEL','GARCIA ZAPICO','H','1963-3-3',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MIGUEL','IBARROLA DIEZ','H','1985-6-8',4);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('ENCARNACION','ASENJO HERNANDO','M','1962-4-8',4);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('FRANCISCO','CALVO BONO','H','1974-8-17',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JOSE ANTONIO','CALVO RODRIGUEZ','H','1989-4-5',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('ANTONIA','MORENO RAYA','M','1976-5-8',1);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JOSE MARIA','FUENTEMILLA ALBERT','H','1979-1-1',4);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('BELEN','PORTERO GRACIA','M','1991-8-10',4);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('LUIS ANTONIO','SUAREZ GARCIA','H','1997-10-18',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('FRANCISCO ANTONIO','BAUTISTA LAMENCA','H','1992-4-9',3);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('SILVIA','PEÑA CASTAN','M','1987-6-8',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('CARMEN','KAAMOUCHI VICENTE','M','1990-10-31',3);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MARIA','LASTRA MOLINA','M','1961-9-29',1);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('ROCIO EMILIA','IZQUIERDO BELTRAN','M','1981-4-1',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('OSCAR','DIEZ NAVARRO','H','1972-6-8',3);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JULIAN ANDRES','MORALES RIERA','H','1998-12-31',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MUJERES','ALCALA PEREZ','M','1970-10-11',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JOSE ANTONIO','GONZALEZ ROY','H','1965-6-19',1);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JOSEFA','GOMEZ EGIDO','M','1998-9-8',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MYRIAM','MORALES ISAC','M','1984-4-15',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('EDURNE','MARTINEZ LASTRA','M','1976-2-2',3);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JUAN JOSE','RIVAS RAMON','H','1994-5-1',4);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('DANIEL JOSE','BLANCO IZQUIERDO','H','1982-5-8',2);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MIRIAN','MONTERO LAMENCA','M','1972-6-18',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MARIA PAZ','BERTIZ SARMIENTO','M','1997-10-18',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('EMILIO','MORILLO RAMON','H','1986-4-8',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('ENRIQUE','FERNANDEZ DIEZ','H','1972-10-7',3);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('ANA TERESA','CASADO CRESPO','M','1971-5-1',4);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('JOSE IGNACIO','MARTIN BERDUN','H','1970-1-18',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('DAVID','PADILLA ORTEGA','H','1960-11-18',4);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('MIGUEL','GARCIA LARRETA','H','1970-2-4',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('LUIS MIGUEL','NAVARRO URRUTIA','H','1969-4-20',5);
INSERT INTO ALUMNADO (Nombre,Apellidos,Sexo,Fecha_Nac,Cod_Curso) VALUES 
('NURIA','AMOSTEGUI LUZURIAGA','M','1970-10-18',2);





INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('MARIA','GOMEZ ANDRES','M','1985-5-4');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('JOSE MANUEL','PADILLA VEGAS','H','1999-5-19');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('RICARDO','MARQUINA HERNANDO','H','1982-2-14');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('MIGUEL','DIAZ FABRE','H','1985-4-24');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('LUIS MIGUEL','AGURRUZA RODRIGUEZ','H','1983-5-25');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('NICOLAS','LOBATO BARRANCO','H','1961-6-14');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('MIGUEL','BURGOS ZAPICO','H','1986-4-2');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('JOSE JESUS','VALDIVIESO JIMENEZ','H','1985-12-15');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('ANA MARIA','BEAMONTE GOMEZ','M','1968-7-24');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('MARIA','LOPEZ CARREÑO','M','1963-5-11');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('MARIA DEL MAR','ASENSIO SEGURA','M','1984-5-14');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('ROSA NIEVES','LARRAÑETA LAZARO','M','1976-6-3');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('ELENA','DAZA FANECA','M','1960-9-14');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('GEMA','PASTOR ADELL','M','1983-2-8');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('MARIA CARMEN','CHECA CANO','M','1960-8-17');
INSERT INTO ALUMNADO_NUEVO (Nombre,Apellidos,Sexo,Fecha_Nac) VALUES 
('JOSE ANTONIO','GRACIA GONZALEZ','H','1962-11-2');


