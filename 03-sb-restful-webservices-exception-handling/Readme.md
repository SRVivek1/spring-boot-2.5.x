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

### Standardizing exception across application
- We can create a shared Exception handler class extending from 'ResponseEntityExceptionHandler'.
- ResponseEntityExceptionHandler class details;
	
	A convenient base class for @ControllerAdvice classes that wish to provide 
	centralized exception handling across all @RequestMapping methods through 
	@ExceptionHandler methods. 
	
	This base class provides an @ExceptionHandler method for handling internal 
	Spring MVC exceptions. This method returns a ResponseEntityfor writing to 
	the response with a message converter,in contrast to DefaultHandlerExceptionResolver 
	which returns a ModelAndView. 
	
- Example:

	@ControllerAdvice
	@RestController
	public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
		@ExceptionHandler(Exception.class)
		public final ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) throws Exception {
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
					request.getDescription(false));
	
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		@ExceptionHandler(UserNotFoundException.class)
		public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
					request.getDescription(false));
	
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
		}
	}

- x

