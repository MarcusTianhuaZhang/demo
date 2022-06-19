# demo
 REST API to manage, search and like/dislike movies.
 
 
 Application built with Spring Boot, 
 
 object relational mapping with JPA, 
 connected to PostgreSQL database,
 
 authentication and authorization with Spring Security

 
 User needs to login to  create, read, update movies.
 
 
 Basic Authorization. 
 
 Login Creditials: 
```
role: ADMIN
username: admin 
password: admin
 
role: USER 
username: user 
password: password
 
 ```
 USER and ADMIN can create, get and update but
 oly ADMIN can delete movie.
 

 ### Sample Create Request:
 ```
 POST http://localhost:8080/api/v1/movie
Content-Type: application/json

{"title": "Ironman",
  "description" : "Marvel movie",
  "releaseYear" : 2013,
  "duration" : 118}
  ```
 ### To read all movies:
 ```
 GET http://localhost:8080/api/v1/movie
 ```
### To search movie by title:
```
GET http://localhost:8080/api/v1/movie?title==movieTitle
```

 ### Sample update request:
 ```

PUT http://localhost:8080/api/v1/movie/Shrek?duration=130.0&description=verygoodone
Content-Type: application/json

```
 ### Delete: 
 ```
 DELETE localhost:8080/api/v1/movie/delete/{movieTitle}
 ```
### like/dislike: 
Login is not required for like/dislike movie to achieve anonymity . 
To like a movie, send a put request to 
```
PUT /api/v1/movie/{movie_title}/like

to dislike: 
PUT /api/v1/movie/{movie_title}/dislike

```

Security implemented by hard-coded usernames and passwords for in memory authentication


