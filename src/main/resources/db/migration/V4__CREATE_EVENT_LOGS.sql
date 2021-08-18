-- Table: public.event_logs

-- DROP TABLE public.event_logs;

CREATE TABLE public.event_logs
(
    id integer NOT NULL,
    created_by character varying(255) COLLATE pg_catalog."default",
    creation_date timestamp without time zone,
    last_modified_by character varying(255) COLLATE pg_catalog."default",
    last_modified_date timestamp without time zone,
    action character varying(255) COLLATE pg_catalog."default",
    context character varying(255) COLLATE pg_catalog."default",
    json character varying(255) COLLATE pg_catalog."default",
    service_name character varying(255) COLLATE pg_catalog."default",
    success_rate boolean,
    counter_id bigint,
    CONSTRAINT event_logs_pkey PRIMARY KEY (id),
    CONSTRAINT fk66bbo3bhwviq95vmk83gnpdnj FOREIGN KEY (counter_id)
        REFERENCES public.counter (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.event_logs
    OWNER to postgre;