## Create Database and Database User (MySQL)
create database `french-app`;
grant all privileges on `french-app`.* to 'french-app'@'localhost' identified by 'french-app' with grant option;
grant all privileges on `french-app`.* to 'french-app'@'%' identified by 'french-app' with grant option;