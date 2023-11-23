drop database if exists deepcodeskill;
create database deepcodeskill;
use deepcodeskill;

CREATE TABLE roles(
id int auto_increment,
name VARCHAR(100),
PRIMARY KEY (id)
);

CREATE TABLE users (
  id int auto_increment ,
  name VARCHAR(100),
  lastname VARCHAR(100),
  lastname2 VARCHAR(100),
  password VARCHAR(50),
  email VARCHAR(100),
  resume blob,
  id_role int ,
  photo blob,
  PRIMARY KEY (id),
  FOREIGN KEY (id_role) REFERENCES roles (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE skills (
  id int auto_increment ,
  skill_name VARCHAR(100),
  description VARCHAR(100),
  PRIMARY KEY (id)
) ;

CREATE TABLE user_skills (
  id_user int,
  id_skill int,
  PRIMARY KEY (id_user, id_skill),
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
  id_interview int,
  id_skill int,
  PRIMARY KEY (id_interview, id_skill),
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
 id_user int,
 id_test int,
 do_at date,
 calification double,
  PRIMARY KEY(id_user, id_test),
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