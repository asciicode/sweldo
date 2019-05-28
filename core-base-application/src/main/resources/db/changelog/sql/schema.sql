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

DROP TABLE IF EXISTS calculation_rule cascade;
CREATE TABLE calculation_rule
(
  id bigInt NOT NULL PRIMARY KEY,
  code varchar(3) NOT NULL,
  description varchar(100) NOT NULL,
  is_rate_a_percentage boolean default false,
  created_date_time timestamp NOT NULL,
  created_by varchar(60) NOT NULL,
  last_modified_date_time timestamp NOT NULL,
  last_modified_by varchar(60) NOT NULL,
  version int NOT NULL
);

drop table if exists pay_element cascade;
drop table if exists pay_element_h cascade;
DROP SEQUENCE IF EXISTS pay_element_id_seq;
create table pay_element (
	id  bigserial not null,	
	code varchar(100) not null,
	description varchar(255),
	organisation_id bigint REFERENCES organisation,
	priority integer,
	multiplier numeric(20,10),
	calculation_rule_id integer references calculation_rule,
	rate numeric(20,6),
	created_date_time timestamp NOT NULL,
	created_by varchar(60) NOT NULL,
	last_modified_date_time timestamp NOT NULL,
	last_modified_by varchar(60) NOT NULL,
	version int NOT NULL,
	primary key (id)	
);
select  create_audit('pay_element');

drop table if exists payroll cascade;
drop table if exists payroll_h cascade;
DROP SEQUENCE IF EXISTS payroll_id_seq;
create table payroll (
	id  bigserial not null,
    payroll_number varchar(100),
    organisation_id  bigint not null REFERENCES organisation,
    payroll_status varchar(100),
    pay_date date not null, 
  	confirm_by_date date,
	overtime boolean default false,
	created_date_time timestamp NOT NULL,
	created_by varchar(60) NOT NULL,
	last_modified_date_time timestamp NOT NULL,
	last_modified_by varchar(60) NOT NULL,
	version int NOT NULL,
	primary key (id),
	CONSTRAINT payroll_idx1 UNIQUE (organisation_id, payroll_number)
);
select  create_audit('payroll');

drop table if exists payroll_employee cascade;
drop table if exists payroll_employee_h cascade;
DROP SEQUENCE IF EXISTS payroll_employee_id_seq;
CREATE TABLE payroll_employee
(
  id bigSerial NOT NULL PRIMARY KEY,
  payroll_id bigint REFERENCES payroll,
  employee_id bigint REFERENCES employee,
  pay_period_end_date date,
  pay_period_start_date date,  
  created_date_time timestamp NOT NULL,
  created_by varchar(60) NOT NULL,
  last_modified_date_time timestamp NOT NULL,
  last_modified_by varchar(60) NOT NULL,
  version int NOT NULL,
  UNIQUE (payroll_id, employee_id)
);
select  create_audit('payroll_employee');

drop table if exists payroll_employee_transaction cascade;
drop table if exists payroll_employee_transaction_h cascade;
DROP SEQUENCE IF EXISTS payroll_employee_transaction_id_seq;
CREATE TABLE payroll_employee_transaction
(
	id bigSerial NOT NULL PRIMARY KEY,
	payroll_employee_id bigint not null REFERENCES payroll_employee,  
	pay_element_id bigint not null references pay_element,
	quantity numeric(20,4),
	rate numeric(20,4),
	amount numeric(30,4),
	multiplier numeric(20,10),
	
	created_date_time timestamp NOT NULL,
	created_by varchar(60) NOT NULL,
	last_modified_date_time timestamp NOT NULL,
	last_modified_by varchar(60) NOT NULL,
	version int NOT NULL
 );
select  create_audit('payroll_employee_transaction'); 


