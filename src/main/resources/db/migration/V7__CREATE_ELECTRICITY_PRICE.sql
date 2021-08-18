create table electricity_price
(
    id                bigint not null
        constraint electricity_price_pkey
            primary key,
    amount            numeric(19, 2),
    calculated        boolean,
    electricity_usage numeric(19, 2),
    end_date          timestamp,
    start_date        timestamp,
    total_hours_usage integer
);

alter table electricity_price
    owner to postgre;

