create table  IF NOT EXISTS counter
(
    id                           bigint    not null
        constraint counter_pkey
            primary key,
    counter_create_date          timestamp not null,
    counter_no                   varchar   not null,
    status                       integer,
    geographical_area_counter_id bigint
        constraint fkjmdsok8camwrxj66tg5mi5rwa
            references geographical_area_counter
);

alter table counter
    owner to postgre;

