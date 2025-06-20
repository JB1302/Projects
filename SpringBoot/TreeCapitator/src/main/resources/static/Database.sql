/*Parte I: Cree una base en MySQL (7 puntos)*/


/*• Cree una base de datos llamada práctica, con una tabla llamada arbol
• La tabla arbol debe tener al menos 5 columnas, una de ellas debe ser un
campo llave primaria y autoincrementa y un campo de texto para
almacenar la ruta de la imagen del arbol
• Los otros 4 campos deben ser unos numéricos y otros de texto
• Debe crear un usuario llamado "usuario_practica" que tenga como clave
"la_Clave" y pueda tener acceso a todos los objetos de la base de datos
práctica.
• La tabla árbol se refiere a tipos de árboles, donde puede existir el nombre
común, tipo de flor, dureza de su madera y demás.*/

/*Eliminar en caso de ya existir*/
drop schema if exists practica;
drop user if exists usuario_practica;

/* Se crea la base de datos*/
CREATE SCHEMA practica;


/*Se crea un usuario para la base de datos "usuario_Practica", y contraseña "la_clave"*/
create user 'usuario_practica'@'%' identified by 'la clave';

/*Se asignan los privilegios sobre la base de datos al usuario creado*/
grant all privileges on practica.* to 'usuario_practica'@'%';
grant select on practica.* to 'usuario_practica'@'%';
flush privileges;

/*Utilizar la base de datos creada*/
use practica;

/*Se crea la tabla arbol*/
create table arbol(
  id_especie INT NOT NULL AUTO_INCREMENT,
  edad INT NOT NULL,
  nombre_comun1 VARCHAR(30) NOT NULL,
  nombre_comun2 VARCHAR(30),
  nombre_Cientifico1 VARCHAR(30) NOT NULL,
  nombre_Cientifico2 VARCHAR(30) NOT NULL,
  ruta_imagen VARCHAR(1024),
PRIMARY KEY(id_especie))
/*Usar el motor primario de MySql*/
ENGINE = InnoDB
/*Definir caracteres a utilizar*/
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO arbol
  (edad, nombre_comun1, nombre_comun2, nombre_Cientifico1, nombre_Cientifico2, ruta_imagen)
VALUES
(15,  'Roble',       'Inglés',        'Quercus',  'robur',        'https://upload.wikimedia.org/wikipedia/commons/a/af/Quercus_robur.jpg'),
(10,  'Cedro',       'Himalayo',      'Cedrus',   'deodara',      'https://upload.wikimedia.org/wikipedia/commons/d/dc/Cedrus_deodara_Manali_2.jpg'),
(8,   'Pino',        'Monterrey',     'Pinus',    'radiata',      'https://upload.wikimedia.org/wikipedia/commons/8/81/Pinus_radiata_BigSur.jpg'),
(20,  'Ceiba',       'Blanca',        'Ceiba',    'pentandra',    'https://upload.wikimedia.org/wikipedia/commons/2/23/Kapok_tree_Honolulu.jpg'),
(7,   'Jacarandá',   'Azul',          'Jacaranda','mimosifolia',  'https://upload.wikimedia.org/wikipedia/commons/6/6c/Jacaranda_mimosifolia_5334.jpg'),
(12,  'Álamo',       'Blanco',        'Populus',  'alba',         'https://upload.wikimedia.org/wikipedia/commons/c/cf/Populus_alba_001.JPG'),
(25,  'Teca',        'Birmana',       'Tectona',  'grandis',      'https://upload.wikimedia.org/wikipedia/commons/c/ca/Starr_010304-0485_Tectona_grandis.jpg'),
(9,   'Bambú',       'Común',         'Bambusa',  'vulgaris',     'https://upload.wikimedia.org/wikipedia/commons/1/10/Golden_Bamboo%28Bambusa_vulgaris%29_in_Hong_Kong.jpg'),
(3,   'Laurel',      'Real',          'Laurus',   'nobilis',      'https://upload.wikimedia.org/wikipedia/commons/7/7c/Laurus_nobilis_001.JPG'),
(18,  'Ciprés',      'Mediterráneo',  'Cupressus','sempervirens', 'https://upload.wikimedia.org/wikipedia/commons/b/b1/Med_Cypress.jpg');
