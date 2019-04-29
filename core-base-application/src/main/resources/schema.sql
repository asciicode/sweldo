--DROP TABLE IF EXISTS audit_revision_details cascade;
-- hibernate auditing table
--CREATE TABLE audit_revision_details
--(
--  id BigSerial PRIMARY KEY,
--  timestamp bigint,
--  revisiondate timestamp,
--  username varchar(255),
--  ip_address varchar(32)
--);

DROP TABLE IF EXISTS user_account cascade;
DROP TABLE IF EXISTS user_account_h cascade;
DROP SEQUENCE IF EXISTS user_account_id_seq;
CREATE TABLE user_account (
    id BigSerial PRIMARY KEY,
    username character varying(50) not null UNIQUE,
    password character varying(150), -- or binary(64) for salt
    employee_id bigint,
    first_name character varying(255),
  	surname character varying(255),
    enabled boolean not null,
    created_date_time timestamp NOT NULL,
	created_by varchar(60) NOT NULL,
	last_modified_date_time timestamp NOT NULL,
	last_modified_by varchar(60) NOT NULL,
	version int NOT NULL
);

	
drop SEQUENCE if exists organition_next_number_seq;
/* CREATE SEQUENCE organition_next_number_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999
  START 10000; */

DROP TABLE IF EXISTS role cascade;
DROP SEQUENCE IF EXISTS role_id_seq;  
CREATE TABLE role
(
  id BigSerial PRIMARY KEY,
  name character varying(50) unique not null,
  description character varying(100),
  created_date_time timestamp NOT NULL,
  created_by varchar(60) NOT NULL,
  last_modified_date_time timestamp NOT NULL,
  last_modified_by varchar(60) NOT NULL,
  version int NOT NULL);

DROP TABLE IF EXISTS user_account_role;
DROP TABLE IF EXISTS user_account_role_h;
DROP SEQUENCE IF EXISTS user_account_role_id_seq; 
CREATE TABLE user_account_role
(
  id BigSerial PRIMARY KEY,
  user_account_id bigint REFERENCES user_account not null, 
  role_id bigint REFERENCES role not null, 
  created_date_time timestamp NOT NULL,
  created_by varchar(60) NOT NULL,
  last_modified_date_time timestamp NOT NULL,
  last_modified_by varchar(60) NOT NULL,
  version int NOT NULL,
  CONSTRAINT user_account_role_idx1 UNIQUE (user_account_id, role_id)
);  

DROP TABLE IF EXISTS organisation cascade;
DROP TABLE IF EXISTS organisation_h;
DROP SEQUENCE IF EXISTS organisation_id_seq;
CREATE TABLE organisation
(
  id BigSerial PRIMARY KEY,
  organisation_number int not null UNIQUE,
  /* status_id integer REFERENCES organisation_status, */
  name varchar(150),
  legal_name varchar(150),  
  
  created_date_time timestamp NOT NULL,
  created_by varchar(60) NOT NULL,
  last_modified_date_time timestamp NOT NULL,
  last_modified_by varchar(60) NOT NULL,
  version int NOT NULL
 );
 

DROP TABLE IF EXISTS employee cascade;
DROP TABLE IF EXISTS employee_h cascade;
DROP SEQUENCE IF EXISTS employee_id_seq; 
CREATE TABLE employee
(  
  id bigserial not null PRIMARY KEY,
  organisation_id bigint not null REFERENCES organisation,
  first_names varchar(255),
  surname varchar(255),
  job_description varchar(100),
  rate numeric(20,4),
  otmultiplier numeric(20,4),
  sss numeric(20,4),
  philhealth numeric(20,4),
  
  created_date_time timestamp NOT NULL,
  created_by varchar(60) NOT NULL,
  last_modified_date_time timestamp NOT NULL,
  last_modified_by varchar(60) NOT NULL,
  version int NOT NULL, 
  UNIQUE (id, organisation_id)
); 
select  create_audit('employee');

DROP SEQUENCE IF EXISTS hibernate_sequence;
CREATE SEQUENCE hibernate_sequence  INCREMENT 1  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  
DROP TABLE IF EXISTS REVINFO cascade;  
create table REVINFO (
    REV integer default 1,
    REVTSTMP bigint,
    primary key (REV)
);

