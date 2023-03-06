# My First Spring Project

This is my first Spring Project. I aim to build a simple RESTful web api

## To run:
At terminal, at root directory run: 
```
./mvnw spring-boot:run
```
Note that `./mvnw` file needs the execution privilege.

## Endpoints

### /hello
returns a JSON format response including a counter (increment after each visit)

### /hello/oh-no
returns a JSON format response including the above counter (DECREMENTED after each visit)

### /hello/make-query?yearOfBirth={year}&name={name}
returns a string representing an SQL query:
```
"SELECT * FROM people WHERE year_of_birth = {year} AND name = {name}";
```

### /hello/multiply-by-two/{input}
returns a string of calculation if input is integer, returns an error message and status code 400 if not.


## PostgreSQL server:
To start, to end and to check status of the PostgresQL server:
```
sudo service postgresql start
sudo service postgresql stop
sudo service postgresql status
```
Connect to the postgres service and open the psql shell: `sudo -u postgres psql`