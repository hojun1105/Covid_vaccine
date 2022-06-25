create database jdb;
create table client(
	num int primary key auto_increment,
	id varchar(120) not null,
	pw varchar(120) not null,
	age int not null,
	gender char not null,
	phone varchar(120) not null
);

alter table client add unique(id);
alter table client modify column gender varchar(120); 

create table hospital(
	num INT primary key auto_increment,
    client_num varchar(120) not null,
	vacType char not null,
	amount int not null,
	age_min int not null,
	age_max int not null,
	startDate DATE not null,
	endDate DATE not null,
	today varchar(80) not null,
	
    foreign key(client_num) references client(id)
);
ALTER TABLE hospital RENAME COLUMN num TO hospitalId;
alter table hospital modify column vacType varchar(120); 
alter table hospital modify column today date;


 

create table injection(
	num INT primary key auto_increment,
	
	client_num varchar(120) not null,
    reserve_num int not null,
	vacType char not null,
	degree int not null,
	part char not null,
	updated date not null,
    
  foreign key(reserve_num) references reservation(reserveNum),
  foreign key(client_num) references client(id)
  
);
ALTER TABLE injection RENAME COLUMN num TO id;
ALTER TABLE injection RENAME COLUMN client_num TO client_id;
ALTER TABLE injection RENAME COLUMN updated TO injection_date;
alter table injection modify column vacType varchar(120); 
alter table injection modify column part varchar(120);

create table reservation(
	reserveNum Int primary key auto_increment,
	client_num varchar(120) not null,
	ReserveDay Date not null,
	injected boolean default false,
	
  foreign key(client_num) references client(id)
);
ALTER TABLE reservation RENAME COLUMN client_num TO clientId;
