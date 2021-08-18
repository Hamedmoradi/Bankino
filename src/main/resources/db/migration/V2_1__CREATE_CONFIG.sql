create table config
(
    id           bigint not null
        constraint config_pkey
            primary key,
    config_key   varchar(255),
    config_type  varchar(255),
    config_value varchar(255)
);

alter table config
    owner to postgre;

