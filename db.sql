create table person(
id number PRIMARY key,
first_name varchar2(100) null,
last_name varchar2(100) null
);


create table person_address(
  person_id number not null,
  address_id number not null,
  primary key(person_id,address_id)
);

create table address(
  address_id number  PRIMARY KEY,
  city varchar(100) null
);

create sequence person_seq NOMAXVALUE noorder cache 10;
create sequence address_seq NOMAXVALUE noorder cache 10;
