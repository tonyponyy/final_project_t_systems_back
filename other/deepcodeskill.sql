drop database if exists deepcodeskill;
create database deepcodeskill;
use deepcodeskill;

CREATE TABLE roles(
id int auto_increment,
name VARCHAR(100),
PRIMARY KEY (id)
);

CREATE TABLE resume(
id int auto_increment,
id_user int,
resume blob,
PRIMARY KEY (id)
);

CREATE TABLE users (
  id int auto_increment ,
  name VARCHAR(100),
  lastname VARCHAR(100),
  lastname2 VARCHAR(100),
  password VARCHAR(255),
  email VARCHAR(100),
  resume_id int,
  id_role int ,
  photo blob,
  PRIMARY KEY (id),
  FOREIGN KEY (id_role) REFERENCES roles (id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (resume_id) REFERENCES resume (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE skills (
  id int auto_increment ,
  skill_name VARCHAR(100),
  description VARCHAR(100),
  PRIMARY KEY (id)
) ;

CREATE TABLE user_skills (
  id int auto_increment ,
  id_skill int,
  id_user int,
  PRIMARY KEY (id),
  FOREIGN KEY (id_user) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_skill) REFERENCES skills (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE interviews (
  id int auto_increment ,
  title VARCHAR(100),
  description VARCHAR(100),
  end_date date,
  PRIMARY KEY (id)
) ;

CREATE TABLE interview_skills (
  id int auto_increment ,
  id_interview int,
  id_skill int,
  PRIMARY KEY (id),
  FOREIGN KEY (id_interview) REFERENCES interviews (id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_skill) REFERENCES skills (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE tests (
  id int auto_increment ,
  id_interview int,
  name VARCHAR(100),
  description VARCHAR(100),
  end_date date,
  PRIMARY KEY (id),
  FOREIGN KEY (id_interview) REFERENCES interviews (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE test_users (
id int auto_increment,
 id_user int,
 id_test int,
 do_at date,
 calification double,
  PRIMARY KEY(id),
   FOREIGN KEY (id_user) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY (id_test) REFERENCES tests (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE user_interviews (
  id int auto_increment ,
  id_user int,
  id_interview int,
  state int default 1 ,
  internal_comment varchar(200),
  stamp int default 0,
  joined_at date,
  PRIMARY KEY (id),
   FOREIGN KEY (id_user) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY (id_interview) REFERENCES interviews (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

-- modificacion para tener mas tamaño en el blob.
ALTER TABLE resume
MODIFY COLUMN resume MEDIUMBLOB CHECK (LENGTH(resume) <= 1048576);

ALTER TABLE users
MODIFY COLUMN photo MEDIUMBLOB CHECK (LENGTH(photo) <= 1048576);

alter table user_skills add qualification float;
alter table user_skills add comment varchar(250);
ALTER TABLE `deepcodeskill`.`user_skills` 
CHANGE COLUMN `qualification` `qualification` FLOAT NULL DEFAULT 0 ;

use deepcodeskill;
-- roles
INSERT INTO `roles` VALUES (1,'user'),(2,'admin'),(3,'hr');
-- users
INSERT INTO `users` VALUES (1,'Recursos Humanos','','','PASSWORDEJEMPLO','email@test.com',NULL,2,NULL),(2,'Juan','Gómez','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','juan.gomez@example.com',NULL,3,NULL),(3,'Ana','Sánchez','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','ana.sanchez@example.com',NULL,1,NULL),(4,'Miguel','Rodríguez','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','miguel.rodriguez@example.com',NULL,3,NULL),(5,'Elena','López','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','elena.lopez@example.com',NULL,1,NULL),(6,'Carlos','Martínez','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','carlos.martinez@example.com',NULL,1,NULL),(7,'María','Pérez','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','maria.perez@example.com',NULL,3,NULL),(8,'Alejandro','Fernández','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','alejandro.fernandez@example.com',NULL,1,NULL),(9,'Sofía','García','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','sofia.garcia@example.com',NULL,1,NULL),(10,'Javier','Díaz','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','javier.diaz@example.com',NULL,3,NULL),(11,'Luisa','Ruiz','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','luisa.ruiz@example.com',NULL,1,NULL),(12,'Pablo','Hernández','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','pablo.hernandez@example.com',NULL,1,NULL),(13,'Carmen','Torres','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','carmen.torres@example.com',NULL,3,NULL),(14,'Ricardo','Jiménez','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','ricardo.jimenez@example.com',NULL,1,NULL),(15,'Isabel','Vargas','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','isabel.vargas@example.com',NULL,1,NULL),(16,'Gabriel','Luna','','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','gabriel.luna@example.com',NULL,3,NULL),(17,'test','test','tester','$2a$10$LiFC0c2lSMYaz7NNxhEgxerauPzFSmrTkvzBlg.zXLKEtDPV4Fduq','test@test.com',NULL,1,NULL);
-- skills 
INSERT INTO `skills` VALUES (1,'Java','Habilidades tecnicas con Java'),(2,'Python','Habilidades tecnicas con Python'),(3,'PHP','Habilidades tecnicas con PHP'),(4,'C#','Habilidades tecnicas con C#'),(5,'Javascript','Habilidades tecnicas con Javascript'),(6,'.NET','Habilidades tecnicas con .NET');
-- users skills
INSERT INTO `user_skills` VALUES (1,1,8),(2,3,1),(3,2,6),(4,5,2),(5,3,3),(6,4,3),(7,4,2),(8,1,4),(9,5,5);
-- interviews
INSERT INTO `interviews` VALUES (1,'Programador full stack java','Buscamos programador full stack java para empezar en nuestra empresa con los siguientes requisitos','2023-12-12'),(2,'Programador PHP','Buscamos programador experimentado en PHP con 2 años de experiencia labroral en el sector','2024-06-06'),(3,'Programador Junior de C#','Buscamos programadores Juniors para un nuevo proyecto de C#','2024-10-10');
-- interviews skills
INSERT INTO `interview_skills` VALUES (1,1,1),(2,2,3),(3,3,4);
-- user interview 
INSERT INTO `user_interviews` (id_user,id_interview,state,internal_comment,joined_at) VALUES (4,2,3,'pendiente de prueba tecnica','2024-06-14'),(8,1,0,'no tiene la skill necesaria','2023-12-13'),(10,3,1,'','2024-10-13'),(13,1,1,'','2023-12-13'),(13,3,0,'no tiene la skill necesaria','2024-11-07'),(15,1,5,'contratada','2003-12-20');
-- test 
INSERT INTO `tests` VALUES (1,1,'Prueba tecnica Java Basica','La prueba tecnica se realizará en las oficinas de Manresa piso 2 a las 5 de la tarde.','2023-12-12'),(2,2,'Prueba tecnica PHP Basica','La prueba tecnica se realizará en las oficinas de Manresa piso 2 a las 5 de la tarde.','2024-06-04'),(3,3,'Prueba tecnica C Basica','La prueba tecnica se realizará en las oficinas de Manresa piso 2 a las 5 de la tarde.','2024-12-08');
-- test users 
INSERT INTO `test_users`(id_user, id_test, do_at, calification) VALUES (13,1,'2024-10-10',8),(13,3,'2024-10-10',4);
