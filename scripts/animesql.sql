create database animedb;
use animedb;
create table anime(
anime_id int not null primary key auto_increment,
name varchar(100)
);
create table hero(
id int not null primary key auto_increment,
name varchar(50)
);
