# demo
 API to manage, search and like/dislike movies.
 
 
 User needs to login to  create, read, update movies.
 
 
 Basic Authorization. 
 
 Login Creditials: 
```
role: ADMIN
username: admin 
password: admin; 
 
role: USER 
username: user 
password: password
 
 ```
 Only admin can delete movie.
 
 ### Saple Create Request:
 ```
 POST http://localhost:8080/api/v1/movie
Content-Type: application/json

{"title": "Ironman",
  "description" : "Marvel movie",
  "releaseYear" : 2013,
  "duration" : 118}
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
Login is not required for like/dislike movie. 
To like a movie, send a put request to 
```
PUT /api/v1/movie/{movie_title}/like

to dislike: 
PUT /api/v1/movie/{movie_title}/dislike

```

Security implemented by hard-coded usernames and passwords for in memory authentication


Spring Boot, JPA, Spring Security
