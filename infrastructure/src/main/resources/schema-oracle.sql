
-- following code is to be executed to create the proper user (local)

--CREATE USER SHARK IDENTIFIED BY "SHARK";
--GRANT CREATE SESSION TO SHARK;
--GRANT CREATE TABLE TO SHARK;
--ALTER DATABASE DEFAULT TABLESPACE users;
--GRANT UNLIMITED TABLESPACE TO SHARK;
--grant CREATE SEQUENCE to SHARK;

--
DROP TABLE SHARK.DIVISIONS;
DROP TABLE SHARK.MEMBERS;
DROP TABLE SHARK.LICENSEPLATES;
DROP TABLE SHARK.PARKINGLOTS;
DROP TABLE SHARK.CONTACT_PERSONS;
DROP SEQUENCE SHARK.MEMBERS_SEQ;
DROP SEQUENCE SHARK.DIVISIONS_SEQ;
DROP SEQUENCE SHARK.LICENSEPLATES_SEQ;
DROP SEQUENCE SHARK.CONTACT_PERSONS;
drop sequence shark.parkinglots;

-- DIVISIONS
DROP TABLE DIVISIONS;
CREATE TABLE DIVISIONS (
  id               NUMBER primary key,
name             VARCHAR2(100) not null,
originalname     VARCHAR2(100) not null,
director         VARCHAR2(100) not null,
parentdivision   NUMBER
);


--SEQUENCE DIVISIONS
DROP SEQUENCE DIVISIONS_SEQ;
CREATE SEQUENCE DIVISIONS_SEQ start with 1 INCREMENT by 1;

--CONTACT_PERSONS
drop table contact_persons;
create table contact_persons (
id number primary key,
name varchar2(100),
telephone_number varchar2(100),
mobile_phone_number varchar2(100),
email varchar2(100),
street_name varchar2(100),
street_number varchar2(100),
postal_code varchar2(100),
label varchar2(100)
);

--SEQUENCE CONTACT_PERSONS
DROP SEQUENCE CONTACT_PERSONS_SEQ;
CREATE SEQUENCE CONTACT_PERSONS_SEQ start with 1 INCREMENT by 1;

--PARKINGLOTS
DROP TABLE PARKINGLOTS;
CREATE TABLE PARKINGLOTS (
id number primary key,
name varchar2(100),
division_id number,
building_type varchar2(100),
capacity number,
price_per_hour_in_euro number,
contact_person_id number,
street_name varchar2(100),
street_number varchar2(100),
postal_code varchar2(100),
label varchar2(100),
constraint fk_division_id foreign key (division_id) references divisions(id),
constraint fk_contact_person_id foreign key (contact_person_id) references contact_persons(id)
);

--SEQUENCE PARKINGLOTS
DROP SEQUENCE PARKINGLOTS_SEQ;
CREATE SEQUENCE PARKINGLOTS_SEQ start with 1 INCREMENT by 1;
