# demo
 API to manage, search and like/dislike movies.
 
 
 User needs to login to  create, read, update movies.
 
 
 Only admin can delete movie.

Login is not required for like/dislike movie. To like a movie, send a put request to 
/api/v1/movie/{movie_title}/like

Security implemented by hard-coded usernames and passwords for in memory authentication
Spring Boot, JPA, Spring Security
