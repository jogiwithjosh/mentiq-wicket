CREATE TABLE public.activity (
    id serial PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    user VARCHAR(20) NOT NULL,
    building VARCHAR(20) NOT NULL,
    status VARCHAR(10) NOT NULL DEFAULT 'TODO'
);