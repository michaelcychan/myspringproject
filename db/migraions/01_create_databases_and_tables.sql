DROP DATABASE IF EXISTS kingdom;

CREATE DATABASE kingdom;

CREATE TABLE monarch(name VARCHAR(60) PRIMARY KEY, year_of_birth INTEGER, year_of_death INTEGER, year_of_reign_start INTEGER, year_of_reign_end INTEGER);
CREATE TABLE prime_minister(id INTEGER PRIMARY KEY, name VARCHAR(60), year_of_birth INTEGER, year_of_death INTEGER, year_start_office INTEGER, year_out_office INTEGER, party VARCHAR(20));