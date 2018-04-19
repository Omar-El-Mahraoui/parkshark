-- copied and adapted code from switchfully-jpa-solution-order

-- following code is to be executed to create the proper user (local)
--CREATE USER SHARK IDENTIFIED BY "SHARK";
--GRANT CREATE SESSION TO SHARK;
--GRANT CREATE TABLE TO SHARK;
--ALTER DATABASE DEFAULT TABLESPACE users;
--GRANT UNLIMITED TABLESPACE TO SHARK;
--grant CREATE SEQUENCE to SHARK;

-- DIVISIONS
DROP TABLE DIVISIONS;
CREATE TABLE DIVISIONS
  (
    ID                 VARCHAR2(100) NOT NULL,
    NAME               VARCHAR2(100) NOT NULL,
    ORIGINAL_NAME      VARCHAR2(100) NOT NULL,
    DIRECTOR           VARCHAR2(100) NOT NULL,
    PARENT_DIVISION_ID VARCHAR2(100),
    CONSTRAINT DIVISIONS_PK PRIMARY KEY (ID),
    --https://www.techonthenet.com/oracle/unique.php
    CONSTRAINT DIVISIONS_NAME_UNIQUE UNIQUE (NAME)
  );

----CONTACT_PERSONS
--DROP TABLE contact_persons;
--CREATE TABLE contact_persons
--(
--  id                  NUMBER PRIMARY KEY,
--  name                VARCHAR2(100),
--  telephone_number    VARCHAR2(100),
--  mobile_phone_number VARCHAR2(100),
--  email               VARCHAR2(100),
--  street_name         VARCHAR2(100),
--  street_number       VARCHAR2(100),
--  postal_code         VARCHAR2(100),
--  label               VARCHAR2(100)
--);

----PARKINGLOTS
--DROP TABLE PARKINGLOTS;
--CREATE TABLE PARKINGLOTS
--  (
--    PARKINGLOTS_ID                     VARCHAR2(100) NOT NULL,
--    PARKINGLOTS_NAME                   VARCHAR2(100) NOT NULL,
--    PARKINGLOTS_DIVISION_ID            VARCHAR2(100) NOT NULL,
--    PARKINGLOTS_CAPACITY               INT NOT NULL,
--    building_type                      VARCHAR2(100) NOT NULL,
--    PARKINGLOTS_PRICE_PER_HOUR_IN_EURO DECIMAL(5,2) NOT NULL,
--    PARKINGLOTS_CONTACT_PERSON_ID      VARCHAR2(100) NOT NULL,
--    CONSTRAINT fk_division_id FOREIGN KEY (division_id) REFERENCES divisions(id),
--    CONSTRAINT fk_contact_person_id FOREIGN KEY (contact_person_id) REFERENCES contact_persons(id)
--  );

---- PHONE_NUMBERS
--DROP TABLE PHONE_NUMBERS;
--CREATE TABLE PHONE_NUMBERS
--  (
--    ID                  VARCHAR2(100) NOT NULL,
--    TELEPHONE_NUMBER    VARCHAR2(100) NOT NULL,
--    MOBILE_PHONE_NUMBER VARCHAR2(100) NOT NULL,
--    CONSTRAINT PHONE_NUMBERS_PK PRIMARY KEY (ID)
--  );