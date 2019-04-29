DROP FUNCTION IF EXISTS create_audit(x varchar(100));
CREATE FUNCTION create_audit(x varchar(100)) returns void  AS $$
DECLARE
 create_table_string varchar := 'CREATE TABLE ' || x || '_h (' || ' id bigint NOT NULL,
  audit_revision bigint NOT NULL,
  action_type smallint, ';
  audit_column RECORD;
begin

FOR audit_column IN SELECT column_name, data_type, is_nullable, character_maximum_length, numeric_precision, numeric_scale from information_schema.columns  
		where table_name = x and column_name <> 'id'
		order by ordinal_position
LOOP
	create_table_string := create_table_string || audit_column.column_name || ' ' || audit_column.data_type;
	if (audit_column.character_maximum_length is not null) then
		create_table_string := create_table_string || '(' || audit_column.character_maximum_length || ')' ;
	end if;
	if (audit_column.data_type ='numeric') then
		create_table_string := create_table_string || '(' || audit_column.numeric_precision || ', ' || audit_column.numeric_scale  || ')' ;
	end if;
	create_table_string := create_table_string || ', ';
END LOOP;	

 create_table_string := create_table_string || 'CONSTRAINT ' || x ||'_h_pkey PRIMARY KEY (id , audit_revision )
 --,CONSTRAINT ' || x || '_h_revision FOREIGN KEY (audit_revision)
 --     REFERENCES audit_revision_details (id) MATCH SIMPLE
 --     ON UPDATE NO ACTION ON DELETE NO ACTION
);';

execute create_table_string;

--EXECUTE 'ALTER TABLE ' || x || '_h OWNER TO ipayrollmaster';
--EXECUTE 'GRANT SELECT, INSERT, UPDATE ON ' || x || '_h TO ipayroll';

end;
$$ LANGUAGE plpgsql;

/*
select  create_audit('organisation');

select * from information_schema.columns where table_name = 'organisation' order by ordinal_position; */