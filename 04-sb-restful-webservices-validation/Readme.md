# Restful web-services

Application: Social media application where user can create posts.

### User Services
- Create a user				- POST /users
- Retrieve a user			- GET /users/{id}
- Retrieve all users 		- GET /users
- Delete a user				- DELETE /users/{id}


### Post Services				
- Create a post for a user		- POST /users/{id}/posts 
- Retrieve all posts of user	- GET /users/{id}/posts
- Retrieve details of a post	- GET /users/{id}/posts/{post_id}

### Implementing validation (For some reason validation is not working. (Skipping for now))
- Spring by default injects Java & Hibernate Validation API but Starting with Boot 2.3, we also need to explicitly add the spring-boot-starter-validation dependency:

	<dependency> 
	    <groupId>org.springframework.boot</groupId> 
	    <artifactId>spring-boot-starter-validation</artifactId> 
	</dependency>

- 