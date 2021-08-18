create table electricity_rate
(
    id                           bigint not null
        constraint electricity_rate_pkey
            primary key,
    price                        numeric(19, 2),
    geographical_area_counter_id bigint
        constraint fkh2a8c1edt1to0r9tr9r6s5cre
            references geographical_area_counter
);

alter table electricity_rate
    owner to postgre;

