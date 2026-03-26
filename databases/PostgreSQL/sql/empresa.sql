CREATE DATABASE empresa;

-- Conéctate a empresa (psql):
-- \c empresa

CREATE SCHEMA IF NOT EXISTS personal;

CREATE TABLE IF NOT EXISTS personal.rol (
  cod_rol_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nom_rol    VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO personal.rol (nom_rol)
VALUES ('Ventas'), ('Almacén'), ('Facturación')
ON CONFLICT (nom_rol) DO NOTHING;

SELECT * FROM personal.rol;