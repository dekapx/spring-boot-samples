-- status table --
create sequence STATUS_ID_SEQ;

create table STATUS (
	ID integer not null default nextval('STATUS_ID_SEQ'::regclass),
	STATUS varchar(25) not null,
	primary key (ID)
);

alter sequence STATUS_ID_SEQ owned by STATUS.id;

-- contact table --
create sequence CONTACT_ID_SEQ;

create table CONTACT (
ID integer not null default nextval('CONTACT_ID_SEQ'::regclass),
	FIRST_NAME varchar(50) not null,
	LAST_NAME varchar(50) not null,
	PHONE varchar(50) not null,
	EMAIL varchar(50) not null,
	STATUS_ID integer not null,
	CREATED_DATE timestamp not null,
	MODIFIED_DATE timestamp not null,
	MODIFIED_BY varchar(50) not null,
	primary key (ID),
	foreign key (STATUS_ID) references STATUS (ID)
);

alter sequence CONTACT_ID_SEQ owned by CONTACT.id;

-- audit table --
create sequence CONTACT_ADT_ID_SEQ;

create table CONTACT_ADT (
	ID integer not null default nextval('CONTACT_ADT_ID_SEQ'::regclass),
	ENTITY_ID integer not null,
	FIELD_NAME varchar(100) not null,
	OLD_VALUE varchar(100) not null,
	NEW_VALUE varchar(100) not null,
	primary key (ID, ENTITY_ID)
);

alter sequence CONTACT_ADT_ID_SEQ owned by CONTACT_ADT.id;


insert into STATUS (STATUS) values('AUTHORISED');
insert into STATUS (STATUS) values('PENDING_AUTHORISED');
insert into STATUS (STATUS) values('PENDING_UPDATE_AUTHORISED');

-- contact table --
create sequence ADDRESS_ID_SEQ;

create table ADDRESS (
ID integer not null default nextval('ADDRESS_ID_SEQ'::regclass),
	HOUSE_NO varchar(20) not null,
	STREET varchar(50) not null,
	CITY varchar(50) not null,
	ZIP varchar(10) not null,
	COUNTY varchar(2) not null,
	COUNTRY varchar(50) not null,
	CONTACT_ID integer default null,
	primary key (ID),
	foreign key (CONTACT_ID) references CONTACT (ID)
);

alter sequence ADDRESS_ID_SEQ owned by ADDRESS.id;