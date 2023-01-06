-- Table: public.booking

DROP TABLE IF EXISTS public."booking";

CREATE TABLE IF NOT EXISTS public."booking"
(
    book_ref text COLLATE pg_catalog."default" NOT NULL,
    book_date date NOT NULL,
    total_amount integer NOT NULL,
    CONSTRAINT "Booking_pkey" PRIMARY KEY (book_ref)

)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."booking"
    OWNER to postgres;

COMMENT ON TABLE public."booking"
    IS 'Бронирование';

insert into "booking" (book_ref,book_date,total_amount)
values
    ('1','2022-10-01',1000),
    ('2','2022-11-01',2000);
