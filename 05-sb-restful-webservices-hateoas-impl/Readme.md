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

### Implementing HATEOAS (Hypermedia As The Engine Of Application State).
- To enable HATEOAS in or application we need to inject SpringBoot HATEOAS dependency.

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-hateoas</artifactId>
	</dependency>

- From Spring 2.5 we have to user 'RepresentationModelProcessor' and 'RepresentationModel' APIs to implement HATEOAS. Please refer to examples provided by Spring on github.

	Ref: https://github.com/spring-projects/spring-hateoas-examples/tree/master/spring-hateoas-and-spring-data-rest


- Note: #1 - RepresentationModelProcessor is not getting invoked if List type is returned from controller. To fix that problem, I created another RepresentationModel bean named Users with property 'List<User>'.
