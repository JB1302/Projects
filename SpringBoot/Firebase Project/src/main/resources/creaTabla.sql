/*Se crea la base de datos solicitada 2 ptos*/
drop schema if exists esquemaBD01;
drop user if exists estudiante01;

/* Se crea la base de datos*/
CREATE SCHEMA esquemaBD01;


/*Se crea un usuario para la base de datos 2 ptos*/
create user 'estudiante01'@'%' identified by '118540180';

/*Se asignan todos los privilegios sobre la base de datos solicitada al usuario creado 2 ptos*/
grant all privileges on esquemaBD01.* to 'estudiante01'@'%';
grant select on esquemaBD01.* to 'estudiante01'@'%';
flush privileges;

/* Se crea la tabla solicitada 2 ptos*/
/*Se crea la tabla arbol*/
USE esquemaBD01;

create table producto(
  id_producto INT NOT NULL AUTO_INCREMENT,
  detalle VARCHAR(30) NOT NULL,
  fecha_vence VARCHAR(10) NOT NULL,
  cantidad INT NOT NULL,
  imagen_producto VARCHAR(1024),
PRIMARY KEY(id_producto))
/*Usar el motor primario de MySql*/
ENGINE = InnoDB
/*Definir caracteres a utilizar*/
DEFAULT CHARACTER SET = utf8mb4;


/*Se insertan 4 registros en la tabla solicitada 2ptos */

INSERT INTO producto (detalle, fecha_vence, cantidad, imagen_producto) VALUES
('Leche Entera', '2025-12-31', 20, 'https://ik.imagekit.io/autoenlinea/imgjpg/tr:f-webp/018804_1.jpg'),
('Arroz Blanco', '2026-02-28', 100, 'https://ik.imagekit.io/autoenlinea/imgjpg/tr:f-webp/873500_1.jpg'),
('Aceite Vegetal', '2025-11-15', 50, 'https://walmartcr.vtexassets.com/arquivos/ids/923391/66910_01.jpg?v=638827668194730000'),
('Galleta Integral', '2025-09-20', 75, 'https://walmartcr.vtexassets.com/arquivos/ids/566123/Galleta-Integral-Pozuelo-Ajonjoli-Tosh-Libre-De-Az-car-252g-1-29039.jpg?v=638458983255730000');
