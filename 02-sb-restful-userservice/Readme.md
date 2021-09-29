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

### Note: #1
- Configure Jackson to not convert Date as time-stamp. In spring 2.5 release this property is set to 'false' by default. 

	spring.jackson.serialization.write-dates-as-timestamps=false
	
###  ServletUriComponentsBuilderUriComponentsBuilder 
	This class provides additional static factory methods to create links based on the current HttpServletRequest. 

- Create link to current user

	ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();


### Error/Exception handling
- We can annotate our custom exception class or methods with "@ResponseStatus" and set the appropriate HTTP Status code to return to caller when these exceptions occurred.
- Spring provides internal class 'ResponseStatusExceptionResolver' to resolve these exception handling.

	@ResponseStatus(HttpStatus.NOT_FOUND)

- Sample response returned to client

	{
	    "timestamp": "2021-01-06T08:02:38.504+00:00",
	    "status": 404,
	    "error": "Not Found",
	    "message": "UserId : 300",
	    "path": "/users/300"
	}



