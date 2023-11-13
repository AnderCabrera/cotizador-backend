CREATE DATABASE CotizadorEnvios;
GO

USE CotizadorEnvios;

DROP TABLE IF EXISTS dbo.users;
DROP TABLE IF EXISTS dbo.regions;
DROP TABLE IF EXISTS dbo.countries;
GO

CREATE TABLE dbo.users (
	id_user   INT 	        NOT NULL IDENTITY(1, 1) PRIMARY KEY,
	username  VARCHAR(120)  NOT NULL,
	user_plan VARCHAR(120)  NOT NULL,
	password  VARCHAR(35)   NOT NULL
);

CREATE TABLE dbo.regions (
	id_region  INT		 NOT NULL IDENTITY(1, 1) PRIMARY KEY,
	region     VARCHAR(120)  NOT NULL,
);

CREATE TABLE dbo.countries (
	id_country  INT		  NOT NULL IDENTITY(1, 1) PRIMARY KEY,
	country	    VARCHAR(120)  NOT NULL,
	id_region   INT           NOT NULL,
	price	    INT	  	  NOT NULL,

	-- Foreign Key
	CONSTRAINT FK_regions_countries
		FOREIGN KEY (id_region)
			REFERENCES dbo.regions(id_region)
);

INSERT INTO dbo.regions(region)
	VALUES ('Europe'),
	       ('Central America'),
	       ('Asia');

INSERT INTO dbo.countries(country, id_region, price)
	VALUES ('Spain', 1, 1000),
	       ('Guatemala', 2, 700),
	       ('Mexico', 2, 500),
	       ('El Salvador', 2, 200),
	       ('Honduras', 2, 300),
	       ('B�lgica', 1, 2000),
	       ('Croacia', 1, 1500),
	       ('M�naco', 1, 400),
	       ('Polonia', 1, 700),
	       ('Ucrania', 1, 1350),
	       ('Israel', 3, 400),
	       ('Qatar', 3, 700),
	       ('Mongolia', 3, 1350),
	       ('Jap�n', 3, 2000);


SELECT * FROM dbo.users;
SELECT * FROM dbo.regions;
SELECT * FROM dbo.countries;
