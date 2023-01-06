-- Table: public.tickets

DROP TABLE IF EXISTS public."tickets";

CREATE TABLE IF NOT EXISTS public."tickets"
(
    ticket_no text COLLATE pg_catalog."default" NOT NULL,
    book_ref text COLLATE pg_catalog."default" NOT NULL,
    passender_id integer NOT NULL,
    passender_name text COLLATE pg_catalog."default" NOT NULL,
    contact_date date NOT NULL,
    CONSTRAINT "tickets_pkey" PRIMARY KEY (ticket_no),
    foreign key (book_ref) references "booking" (book_ref)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."tickets"
    OWNER to postgres;

COMMENT ON TABLE public."tickets"
    IS 'Билеты';

insert into "tickets" (ticket_no,book_ref,passender_id,passender_name,contact_date)
values
    ('1','1', 1,'Petrov', '2022-10-01'),
    ('2','1', 2,'Ivanov', '2022-11-01'),
    ('3','2', 3,'Borisov', '2022-11-01'),
    ('4','2', 4,'Borisova', '2022-11-01');

