CREATE TABLE public.user (
    id serial PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE public.building (
    id serial PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE public.activity (
    id serial PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    user_id integer REFERENCES public.user,
    building_id integer REFERENCES public.building
);