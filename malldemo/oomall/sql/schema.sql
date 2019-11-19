drop database if exists oomall;
drop user if exists 'ooadUser'@'%';
create database oomall default character set utf8mb4 collate utf8mb4_unicode_ci;
use oomall;
create user 'ooadUser'@'%' identified by 'xxxx';
grant all privileges on oomall.* to 'ooadUser'@'%';
flush privileges;