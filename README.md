# What is this repository about?
I wrote an API for retrieving and storing information 
about countries. It uses an H2 database to store country data based 
on the ISO 3166-1 alpha-3 code. If the data is not available 
in the database, the API fetches it from an external source 
(restcountries.com), saves it to the database, and returns it 
to the user.

## Technologies
- Spring Boot
- Spring Data JPA
- H2 Database
