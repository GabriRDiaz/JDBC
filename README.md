# Ej5Grd
**Conexión a DB usando JDBC**

**FEATURES** (Nota: De encontrar un bug, sepa que no se trata de un bug, si no de una feature no listada xP ).

- JDBC
  - INSERT, DELETE, UPDATE, SELECT.
- Programa con GUI usando Swing.
  - GUI creada co NetBeans.
-JMenuBar.
  - Opciones
    - Cambiar usuario.
    - Cargar datos.
    - Limpiar datos
  - Informes
    - Cargar Facturas.
      - Si DNI != null --> Factura de cliente.
      - Si DNI == null --> Facturas globales.
   - Cargar clientes.
      - Clientes globales.  
- Librería JCalendar.
  - JDateChooser.
- Validación de DNI.

**IMÁGENES** 

[Login](https://imgur.com/2Nkn7z2)

[Main menu](https://imgur.com/undefined)

[JTable](https://imgur.com/J2vwkJb)

[JDateChooser](https://imgur.com/rVR2WWC)

**SCRIPT DB**

DROP DATABASE IF EXISTS Acme;

CREATE DATABASE IF NOT EXISTS Acme;

USE Acme;

CREATE TABLE Clientes (
	DNI VARCHAR (9) NOT NULL, 
	Nombre VARCHAR (15) NOT NULL, 
	Ape1 VARCHAR (20) NOT NULL, 
	Ape2 VARCHAR (20) NULL, 
	Fec_Nac DATE NOT NULL,
	PRIMARY KEY (DNI)
);

CREATE TABLE Facturas (
	Num_Fact INTEGER(15) NOT NULL AUTO_INCREMENT,
	Fecha DATE NOT NULL,
	Importe DECIMAL(9, 2) NOT NULL,
	Moneda VARCHAR(10) NOT NULL,
	Cliente VARCHAR (9) NULL,
	PRIMARY KEY (Num_Fact),
	FOREIGN KEY (Cliente) REFERENCES Clientes (DNI) ON UPDATE CASCADE ON DELETE SET NULL
);

INSERT INTO Clientes (DNI, Nombre, Ape1, Ape2, Fec_Nac) 
	VALUES ('31156465G', 'John', 'Smith', NULL, '1969/01/14'), 
		   ('51561414F', 'Javier', 'Penedo', 'Naya', '1991/12/21'), 
		   ('23482341H', 'Jane', 'Martin', NULL, '1965/11/13'), 
		   ('42545642L', 'Marta', 'Isla', 'Varela', '1982/06/07'), 
		   ('53128739J', 'Miguel', 'Portillo', 'Oseiro', '1974/08/25'),
		   ('12345678A', 'Peter', 'Parker', NULL, '1950/03/14');

INSERT INTO Facturas (Num_Fact, Fecha, Importe, Moneda, Cliente)
	VALUES ('1', '2016/03/13', '130.45', 'Euro', '23482341H'),
		   ('2', '2015/11/23', '86.04', 'Dolar', '53128739J'),
		   ('3', '2016/03/23', '34.58', 'Euro', '23482341H'),
		   ('4', '2015/12/13', '14.58', 'Libra', '51561414F'),
		   ('5', '2016/01/16', '55.55', 'Euro', '12345678A');
