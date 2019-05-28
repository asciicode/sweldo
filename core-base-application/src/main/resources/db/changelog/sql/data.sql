delete from user_account;
delete from role;
delete from user_account_role;

INSERT INTO user_account (username, password, enabled, created_by, created_date_time, last_modified_by, last_modified_date_time, version) VALUES 
	('allen', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true, 'System', now(),'System', now(), 0),
	('cecille', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true, 'System', now(),'System', now(), 0),
	('nanie', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true, 'System', now(),'System', now(), 0);

INSERT INTO role(
            name, description, created_date_time, created_by, last_modified_date_time, last_modified_by,  version)
    VALUES
    ('ROLE_USER','External User', current_timestamp , 'System', current_timestamp , 'System',0),
	('ROLE_GROUP_USER','Group User', current_timestamp , 'System', current_timestamp , 'System',0)
;

insert into user_account_role
(user_account_id, role_id ,created_by, created_date_time,   last_modified_by, last_modified_date_time, version)
values (1, 2, 'System', now(),'System', now(), 0),
 (2, 2, 'System', now(),'System', now(), 0),
 (3, 2, 'System', now(),'System', now(), 0);
 
delete from organisation;
insert into organisation
(organisation_number, name, legal_name, created_by, created_date_time,   last_modified_by, last_modified_date_time, version)
values (30000 , 'Atzkarl Printing', 'Atzkarl Printing', 'System', now(),'System', now(), 0);

delete from calculation_rule;
INSERT INTO calculation_rule
(id, code, description, is_rate_a_percentage, created_date_time, created_by, last_modified_date_time, last_modified_by, version)
VALUES (0,'R','Employee Rate Amount', false, now(), 'System', now(),'System', 0),
	(1,'OT','Employee OT multiplier', false, now(), 'System', now(),'System', 0),
	(2,'SSS','Employee SSS', false, now(), 'System', now(),'System', 0),
	(3,'PH','Employee PhilHealth',false, now(), 'System', now(),'System', 0);

delete from pay_element;
INSERT INTO pay_element
(id, code, description, organisation_id, priority, multiplier, calculation_rule_id, rate, created_date_time, created_by, last_modified_date_time, last_modified_by, version)
VALUES (0,'R','Employee Rate Amount', null, 1, 1, 0, 0, now(), 'System', now(),'System', 0),
	(1,'OT','Employee OT multiplier', null, 1, 1, 1, 0, now(), 'System', now(),'System', 0),
	(2,'SSS','Employee SSS', null, 1, 1, 2, 0, now(), 'System', now(),'System', 0),
	(3,'PH','Employee PhilHealth',null, 1, 1, 3, 0, now(), 'System', now(),'System', 0);