CREATE TABLE produit(
	PRO_ID INT NOT NULL AUTO_INCREMENT,
	PRO_LABEL VARCHAR(150) NOT NULL,
	PRO_PRICE DECIMAL(10, 2) NOT NULL,
	PRO_CREATED_ON DATE NOT NULL,
	PRIMARY KEY(PRO_ID)
);

CREATE TABLE utilisateur(
	UTI_ID INT NOT NULL AUTO_INCREMENT,
	UTI_USERNAME VARCHAR(50) NOT NULL,
	UTI_PASSWORD VARCHAR(300) NOT NULL,
	UTI_ADMIN BIT NOT NULL,
	UTI_DESACTIVE BIT NOT NULL,
	PRIMARY KEY(UTI_ID)
);