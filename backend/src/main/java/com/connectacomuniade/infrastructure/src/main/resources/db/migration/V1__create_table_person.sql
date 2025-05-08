CREATE SCHEMA IF NOT EXISTS persons;

CREATE TABLE persons.person(
    id SERIAL PRIMARY KEY,
    ref UUID NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    identification_number VARCHAR(20) NOT NULL UNIQUE,
    birthdate DATE NOT NULL,
    phone_number VARCHAR(20) NOT NULL UNIQUE
);