--CREATE DATABASE CotizadorEnvios;
--GO

USE CotizadorEnvios;

DROP TABLE IF EXISTS dbo.users;
DROP TABLE IF EXISTS dbo.countries;
DROP TABLE IF EXISTS dbo.regions;
DROP TABLE IF EXISTS dbo.fee;
GO

CREATE TABLE dbo.users (
	id_user   INT 		    NOT NULL IDENTITY(1, 1) PRIMARY KEY,
	username  VARCHAR(120)  NOT NULL,
	sub_plan  VARCHAR(120)  NOT NULL,
	password  VARCHAR(35)   NOT NULL
);

CREATE TABLE dbo.countries (
	id_country  INT		      NOT NULL IDENTITY(1, 1) PRIMARY KEY,
	country		VARCHAR(120)  NOT NULL
);

CREATE TABLE dbo.regions (
	id_region    INT			NOT NULL IDENTITY(1, 1) PRIMARY KEY,
	region_name  VARCHAR(120)   NOT NULL 
);

CREATE TABLE dbo.fee (
	id_fee                 INT  NOT NULL IDENTITY(1, 1) PRIMARY KEY,
	id_country_origin      INT  NOT NULL,
	id_country_destination INT  NOT NULL,
	id_region              INT  NOT NULL,
	cost	               INT  NOT NULL

	-- Foreign key
	CONSTRAINT FK_regions_fee
		FOREIGN KEY (id_region)
			REFERENCES dbo.regions(id_region),

	CONSTRAINT FK_origin_countries_fee
		FOREIGN KEY (id_country_origin)
			REFERENCES dbo.regions(id_region),

	CONSTRAINT FK_destination_countries_fee
		FOREIGN KEY (id_country_destination)
			REFERENCES dbo.regions(id_region),
);

/*CREATE TABLE dbo.packages (
	id_package			INT			  NOT NULL  IDENTITY(1, 1) PRIMARY KEY,
	weight				INT			  NOT NULL,
	width				INT			  NOT NULL,
	height				INT			  NOT NULL,
	length				INT			  NOT NULL,
	country_origin      VARCHAR(120)  NOT NULL,
	destination_Country VARCHAR(120)  NOT NULL,
	
	-- Foreign keys
	CONSTRAINT FK_countries_packages
		FOREIGN KEY (country_origin)
			REFERENCES dbo.countries(id_country),
	CONSTRAINT FK_countries_packages
		FOREIGN KEY (country_origin)
			REFERENCES dbo.countries(id_country)
);*/

INSERT INTO dbo.users(username, sub_plan, password)
	VALUES ('acabrera', 'Super Premium', '123'),
		   ('John', 'Premium', '123');

INSERT INTO dbo.countries(country)
	VALUES ('Spain'),
		   ('Guatemala');

INSERT INTO dbo.regions(region_name)
	VALUES ('Europe'),
		   ('Central America');

INSERT INTO dbo.fee(id_country_origin, id_country_destination, id_region, cost)
	VALUES (1, 2, 2, 1500),
		   (2, 1, 1, 2000);

SELECT * FROM dbo.users;
SELECT * FROM dbo.countries;
SELECT * FROM dbo.regions;
SELECT * FROM dbo.fee;