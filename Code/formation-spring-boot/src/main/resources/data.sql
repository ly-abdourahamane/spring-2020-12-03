INSERT INTO produit (PRO_ID, PRO_LABEL, PRO_PRICE, PRO_CREATED_ON) VALUES (1, 'GoPRO HERO 8', 499.99, NOW());
INSERT INTO produit (PRO_ID, PRO_LABEL, PRO_PRICE, PRO_CREATED_ON) VALUES (2, 'Parachute de France', 2000, NOW());

INSERT INTO utilisateur (UTI_ID, UTI_USERNAME, UTI_PASSWORD, UTI_ADMIN, UTI_DESACTIVE) VALUES (1, 'admin', '$2a$10$ryV4Fr8.3tXanejPDxecgOTC/5Nu6iO2eoGcqotwVWveEOQUtVYTu', 1, 0);
INSERT INTO utilisateur (UTI_ID, UTI_USERNAME, UTI_PASSWORD, UTI_ADMIN, UTI_DESACTIVE) VALUES (2, 'user', '$2a$10$ryV4Fr8.3tXanejPDxecgOTC/5Nu6iO2eoGcqotwVWveEOQUtVYTu', 0, 1);