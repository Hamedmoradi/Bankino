create table counter_alarm
(
    id         bigint not null
        constraint counter_alarm_pkey
            primary key,
    alarm_date timestamp,
    alarm_name varchar(255),
    alarm_type varchar(255),
    counter_id bytea
);

alter table counter_alarm
    owner to postgre;

