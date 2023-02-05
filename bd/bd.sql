show databases;
create database crud_java_jframe;
use crud_java_jframe;
show tables;
create table Texto(
	id int auto_increment not null,
    titulo varchar(255),
    tema varchar(255),
    texto mediumtext,
    primary key(id)
);
select * from Texto where titulo like "Teste";
select * from Texto;
create table login(
	id int auto_increment not null,
    nome varchar(255),
    usuario varchar(255),
    senha varchar(255),
    primary key(id)
);
insert into login(nome, usuario, senha) value("placydo", "placydo", "placydo");
select * from login;