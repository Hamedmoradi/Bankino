create table geographical_area_counter
(
    id           bigint not null
        constraint geographical_area_counter_pkey
            primary key,
    city         varchar,
    county       varchar,
    municipality varchar,
    neighborhood varchar,
    province     varchar,
    village      varchar
);

alter table geographical_area_counter
    owner to postgre;

