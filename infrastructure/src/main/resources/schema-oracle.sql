-- copied and adapted code from switchfully-jpa-solution-order

-- following code is to be executed to create the proper user (local)
--CREATE USER SHARK IDENTIFIED BY "SHARK";
--GRANT CREATE SESSION TO SHARK;
--GRANT CREATE TABLE TO SHARK;
--ALTER DATABASE DEFAULT TABLESPACE users;
--GRANT UNLIMITED TABLESPACE TO SHARK;
--grant CREATE SEQUENCE to SHARK;

--DROP TABLES
DROP TABLE DIVISIONS;

-- DIVISIONS
CREATE TABLE DIVISIONS
  (
    DIVISIONS_ID                 VARCHAR2(100) NOT NULL,
    DIVISIONS_NAME               VARCHAR2(100) NOT NULL,
    DIVISIONS_ORIGINAL_NAME      VARCHAR2(100) NOT NULL,
    DIVISIONS_DIRECTOR           VARCHAR2(100) NOT NULL,
    DIVISIONS_PARENT_DIVISION_ID VARCHAR2(100),
    CONSTRAINT DIVISIONS_PK PRIMARY KEY (DIVISIONS_ID),
    --https://www.techonthenet.com/oracle/unique.php
    CONSTRAINT DIVISIONS_NAME_UNIQUE UNIQUE (DIVISIONS_NAME)
  );


----SEQUENCE DIVISIONS
--DROP SEQUENCE DIVISIONS_SEQ;
--CREATE SEQUENCE DIVISIONS_SEQ start with 1 INCREMENT BY 1;
--  --CONTACT_PERSONS
--  DROP TABLE contact_persons;
--  CREATE TABLE contact_persons
--    (
--      id                  NUMBER PRIMARY KEY,
--      name                VARCHAR2(100),
--      telephone_number    VARCHAR2(100),
--      mobile_phone_number VARCHAR2(100),
--      email               VARCHAR2(100),
--      street_name         VARCHAR2(100),
--      street_number       VARCHAR2(100),
--      postal_code         VARCHAR2(100),
--      label               VARCHAR2(100)
--    );
--  --SEQUENCE CONTACT_PERSONS
--  DROP SEQUENCE CONTACT_PERSONS_SEQ;
--CREATE SEQUENCE CONTACT_PERSONS_SEQ start with 1 INCREMENT BY 1;
--  --PARKINGLOTS
--  DROP TABLE PARKINGLOTS;
--  CREATE TABLE PARKINGLOTS
--    (
--      id                                 NUMBER PRIMARY KEY,
--      name                               VARCHAR2(100) NOT NULL,
--      division_id                        NUMBER NOT NULL,
--      building_type                      VARCHAR2(100) NOT NULL,
--      capacity                           NUMBER NOT NULL,
--      price_per_hour_in_euro             NUMBER NOT NULL,
--      contact_person_name                VARCHAR2(100) NOT NULL,
--      contact_person_tele_phone_number   VARCHAR2(100) NOT NULL,
--      contact_person_mobile_phone_number VARCHAR2(100) NOT NULL,
--      contact_person_email               VARCHAR2(100) NOT NULL,
--      street_name                        VARCHAR2(100) NOT NULL,
--      street_number                      VARCHAR2(100) NOT NULL,
--      postal_code                        VARCHAR2(100) NOT NULL,
--      label                              VARCHAR2(100) NOT NULL,
--      CONSTRAINT fk_division_id FOREIGN KEY (division_id) REFERENCES divisions(id),
--      CONSTRAINT fk_contact_person_id FOREIGN KEY (contact_person_id) REFERENCES contact_persons(id)
--    );
--  --SEQUENCE PARKINGLOTS
--  DROP SEQUENCE PARKINGLOTS_SEQ;
--CREATE SEQUENCE PARKINGLOTS_SEQ start with 1 INCREMENT BY 1;
