create database deepcodeskill;
use deepcodeskill;

CREATE TABLE users (
  id int auto_increment ,
  name VARCHAR(100),
  lastname VARCHAR(100),
  lastname2 VARCHAR(100),
  password VARCHAR(50),
  email VARCHAR(100),
  resume blob,
  role int ,
  photo blob,
  PRIMARY KEY (id)
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
  KEY id_user (id_user),
   FOREIGN KEY (id_user) REFERENCES users (id),
   KEY id_skill (id_skill),
   FOREIGN KEY (id_skill) REFERENCES skills (id)
) ;

CREATE TABLE interviews (
  id int auto_increment ,
  title VARCHAR(100),
  description VARCHAR(100),
  endDate date,
  PRIMARY KEY (id)
) ;

CREATE TABLE interview_skills (
  id_interview int,
  id_skill int,
  KEY id_inrterview (id_interview),
   FOREIGN KEY (id_interview) REFERENCES interviews (id),
   KEY id_skill (id_skill),
   FOREIGN KEY (id_skill) REFERENCES skills (id)
) ;

CREATE TABLE tests (
  id int auto_increment ,
  id_interview int,
  title VARCHAR(100),
  description VARCHAR(100),
  endDate date,
  PRIMARY KEY (id),
   FOREIGN KEY (id_interview) REFERENCES interviews (id),
   KEY id_interview (id_interview)
) ;

CREATE TABLE test_users (
   id_user int,
  id_test int,
  do_at date,
  calification double,
  KEY id_user (id_user),
   FOREIGN KEY (id_user) REFERENCES users (id),
   KEY id_test (id_test),
   FOREIGN KEY (id_test) REFERENCES tests (id)
) ;

CREATE TABLE user_interviews (
  id_user int,
  id_interview int,
  state int default 1 ,
  internal_comment varchar(200),
  stamp int,
  joined_at date,
  KEY id_user (id_user),
   FOREIGN KEY (id_user) REFERENCES users (id),
   KEY id_interview (id_interview),
   FOREIGN KEY (id_interview) REFERENCES interviews (id)
) ;

