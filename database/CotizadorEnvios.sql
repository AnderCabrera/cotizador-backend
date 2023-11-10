--CREATE DATABASE CotizadorEnvios;
--GO

USE CotizadorEnvios;

DROP TABLE IF EXISTS dbo.users;
DROP TABLE IF EXISTS dbo.countries;
DROP TABLE IF EXISTS dbo.packages;
GO

CREATE TABLE dbo.users (
	id_user   INT 		    NOT NULL IDENTITY(1, 1) PRIMARY KEY,
	username  VARCHAR(120)  NOT NULL,
	sub_plan  VARCHAR(120)  NOT NULL,
	password  VARCHAR(35)   NOT NULL
);

CREATE TABLE dbo.countries (
	id_country  INT		      NOT NULL IDENTITY(1, 1) PRIMARY KEY,
	country		VARCHAR(120)  NOT NULL,
	region		VARCHAR(120)  NOT NULL,
	price		INT			  NOT NULL
);

CREATE TABLE dbo.packages (
	id_package			   INT  NOT NULL  IDENTITY(1, 1) PRIMARY KEY,
	weight				   INT	NOT NULL,
	width				   INT	NOT NULL,
	height			       INT	NOT NULL,
	length				   INT	NOT NULL,
	id_country_origin      INT	NOT NULL,
	id_country_destination INT	NOT NULL,
	
	-- Foreign keys
	CONSTRAINT FK_origin_countries_packages
		FOREIGN KEY (id_country_origin)
			REFERENCES dbo.countries(id_country),
	CONSTRAINT FK_destination_countries_packages
		FOREIGN KEY (id_country_destination )
			REFERENCES dbo.countries(id_country)
);

INSERT INTO dbo.users(username, sub_plan, password)
	VALUES ('acabrera', 'Super Premium', '123'),
		   ('John', 'Premium', '123');

INSERT INTO dbo.countries(country, region, price)
	VALUES ('Spain', 'Europe', 1000),
		   ('Guatemala', 'Central America', 700);

INSERT INTO dbo.packages(weight, width, height, length, id_country_origin, id_country_destination)
	VALUES (2, 4, 5, 8, 2, 1);

SELECT * FROM dbo.users;
SELECT * FROM dbo.countries;
SELECT * FROM dbo.packages;