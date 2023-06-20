DROP SCHEMA IF EXISTS inventory;
CREATE SCHEMA inventory;

alter table if exists device
drop constraint if exists FKgtdii1rt0lq0uf03mapotktur;

alter table if exists device_config_aud
drop constraint if exists FKj3dcp113oq5w2mqxxcagbf7fr;

alter table if exists device_config
drop constraint if exists FK4dn7dn4gj01f2itqjmca7ktq1;

drop table if exists device cascade;
drop table if exists device_config_aud cascade;
drop table if exists device_config cascade;
drop table if exists revinfo cascade;
drop sequence if exists device_config_id_sequence;
drop sequence if exists device_id_sequence;
drop sequence if exists hibernate_sequence;


create sequence device_config_id_sequence start 1 increment 50;
create sequence device_id_sequence start 1 increment 50;
create sequence hibernate_sequence start 1 increment 1;


create table device (
                        id int4 not null,
                        serial varchar(255),
                        vendor varchar(255),
                        device_id int4,
                        primary key (id)
);


create table device_config_aud (
                                   id int4 not null,
                                   rev int4 not null,
                                   revtype int2,
                                   pin_code NUMERIC(7,0) NOT NULL,
                                   primary key (id, rev)
);


create table device_config (
                               id int4 not null,
                               device_status varchar(255),
                               pin_code NUMERIC(7,0) NOT NULL,
                               temperature int4,
                               device_id int4,
                               primary key (id)
);


create table revinfo (
                         rev int4 not null,
                         revtstmp int8,
                         primary key (rev)
);


alter table if exists device
    add constraint FKgtdii1rt0lq0uf03mapotktur
    foreign key (device_id)
    references device_config;


alter table if exists device_config_aud
    add constraint FKj3dcp113oq5w2mqxxcagbf7fr
    foreign key (rev)
    references revinfo;


alter table if exists device_config
    add constraint FK4dn7dn4gj01f2itqjmca7ktq1
    foreign key (device_id)
    references device;