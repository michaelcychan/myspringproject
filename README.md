# My First Spring Project

This is my first Spring Project. I aim to build a simple RESTful web api

## To run:
At terminal, at root directory run: 
```
./mvnw spring-boot:run
```
Note that `./mvnw` file needs the execution privilege.

If database password is encrypted with Jasypt, please use the following:
```
 ./mvnw spring-boot:run -Dspring-boot.run.arguments=--jasypt.encryptor.password=[SECRET KEY]
```

## Endpoints

### /kingdom
The queries under `/kingdom` are using a database containing two tables. You can find the database data under `/db/migration`.  

- `/find-all-monarch`
- `/monarch-of-year/{year}`  
-- will return error if year is before 1951 or after this year
- `/get-monarch/{name}`
- `/find-all-pm`  
-- returns all pm from Churchill
- `/find-pm-by-monarch/{monarch}`
-- find the pms appointed by the named monarch
- `/find-pm-by-year/{year}`  
  -- will return error if year is before 1951 or after this year
- `/latest-pm`  
-- will return the latest pm

### /hello 
(All under the subdomain hello are for testings)  
returns a JSON format response including a counter (increment after each visit)

- `/oh-no`  
---returns a JSON format response including the above counter (DECREMENTED after each visit)
- `/hello/make-query?yearOfBirth={year}&name={name}`  
--returns a string representing an SQL query:
```
"SELECT * FROM people WHERE year_of_birth = {year} AND name = {name}";
```
- `/hello/multiply-by-two/{input}`  
-- returns a string of calculation if input is integer, returns an error message and status code 400 if not.

## Create an encrypted password

Guide: https://www.geeksforgeeks.org/how-to-encrypt-passwords-in-a-spring-boot-project-using-jasypt/  
1. Go the here: https://www.devglan.com/online-tools/jasypt-online-encryption-decryption  


## PostgreSQL server:
To start, to end and to check status of the PostgresQL server:
```
sudo service postgresql start
sudo service postgresql stop
sudo service postgresql status
```
Connect to the postgres service and open the psql shell: `sudo -u postgres psql`