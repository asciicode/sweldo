delete from user_account;
INSERT INTO user_account (username, password, enabled, created_by, created_date_time, last_modified_by, last_modified_date_time, version) VALUES 
	('allen', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true, 'System', now(),'System', now(), 0),
	('cecille', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true, 'System', now(),'System', now(), 0),
	('nanie', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true, 'System', now(),'System', now(), 0);

delete from role;
INSERT INTO role(
            name, description, created_date_time, created_by, last_modified_date_time, last_modified_by,  version)
    VALUES
    ('ROLE_USER','External User', current_timestamp , 'System', current_timestamp , 'System',0),
	('ROLE_GROUP_USER','Group User', current_timestamp , 'System', current_timestamp , 'System',0)
;

delete from user_account_role;
insert into user_account_role
(user_account_id, role_id ,created_by, created_date_time,   last_modified_by, last_modified_date_time, version)
values (1, 2, 'System', now(),'System', now(), 0),
 (2, 2, 'System', now(),'System', now(), 0),
 (3, 2, 'System', now(),'System', now(), 0);
 
delete from organisation;
insert into organisation
(organisation_number, name, legal_name, created_by, created_date_time,   last_modified_by, last_modified_date_time, version)
values (30000 , 'Atzkarl Printing', 'Atzkarl Printing', 'System', now(),'System', now(), 0);



