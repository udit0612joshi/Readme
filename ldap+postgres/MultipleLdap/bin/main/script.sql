create table users (id SERIAL not null , email varchar(255), first_name varchar(255), last_name varchar(255), username varchar(255), primary key (id)) ;
INSERT INTO users (email, first_name, last_name, username) values ('dhiraj@devglan.com', 'Dhiraj', 'Ray', 'only2dhir');
INSERT INTO users (email, first_name, last_name, username) values ('mike@gmail.com', 'Mike', 'Huss', 'mikehuss');