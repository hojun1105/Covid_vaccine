create database jdb;
use jdb;
drop database jdb;

create table client(
	num int primary key auto_increment,
	id varchar(120) not null,
	pw varchar(120) not null,
	age int not null,
	gender varchar(120) not null,
	phone varchar(120) not null
);

alter table client add unique(id);

create table hospital(
	hospitalId INT primary key auto_increment,
	vacType varchar(120) not null,
	amount int not null,
	age_min int not null,
	age_max int not null,
	startDate DATE not null,
	endDate DATE not null,
	today Date not null

);



 

create table injection(
	id INT primary key auto_increment,
	client_id varchar(120) not null,
    reserve_num int not null,
	vacType varchar(120) not null,
	degree int not null,
	part varchar(120) not null,
	injection_date date not null,
    
  foreign key(reserve_num) references reservation(reserveNum),
  foreign key(client_id) references client(id)
);



create table reservation(
	reserveNum Int primary key auto_increment,
	clientId varchar(120) not null,
	ReserveDay Date not null,
	injected boolean default false,
	
  foreign key(clientId) references client(id)
);

select * from client;
select * from reservation;
select * from injection;
select * from hospital;
