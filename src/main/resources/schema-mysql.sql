use tour;
start transaction;

SET FOREIGN_KEY_CHECKS=0;
drop table if exists state;
drop table if exists city;
drop table if exists visit;
drop table if exists user;
SET FOREIGN_KEY_CHECKS=1;

create table user (
  user_id int UNSIGNED not null auto_increment,
  first_name varchar(100),
  last_name varchar(100),
  username varchar(50) not null unique,
  password varchar(200) not null,
  primary key (user_id)
);

create table state (
  state_id int UNSIGNED not null auto_increment,
  state_name varchar(100),
  state_abbreviation varchar(10),
  primary key (state_id)
);

create table city (
  city_id int UNSIGNED not null auto_increment,
  city_name varchar(100),
  status varchar(20) default 'verified',
  state_id int UNSIGNED not null,
  latitude DECIMAL(9, 6),
  longitude DECIMAL(9, 6),
  primary key (city_id),
  foreign key (state_id) references state(state_id)
);

create table visit (
  visit_id int UNSIGNED not null auto_increment,
  user_id int UNSIGNED not null,
  city_id int UNSIGNED not null,
  primary key (visit_id),
  foreign key (user_id) references user(user_id),
  foreign key (city_id) references city(city_id)
);

commit;