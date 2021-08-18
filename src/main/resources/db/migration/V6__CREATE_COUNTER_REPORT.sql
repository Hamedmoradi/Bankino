create table counter_report
(
    id                           bigint not null
        constraint counter_report_pkey
            primary key,
    send_confirmation_data       boolean,
    usage                        numeric(19, 2),
    end_date                     timestamp,
    hour                         integer,
    start_date                   timestamp,
    counter_id                   bigint
        constraint fk84uctayk0k7nhduhjpa5utjb3
            references counter,
    geographical_area_counter_id bigint
        constraint fko351n0ww34l6rstr2tda1m1p3
            references geographical_area_counter
);

alter table counter_report
    owner to postgre;

