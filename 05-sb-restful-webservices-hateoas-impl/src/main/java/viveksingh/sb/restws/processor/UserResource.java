/**
 * 
 */
package viveksingh.sb.restws.processor;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import viveksingh.sb.restws.bean.User;
import viveksingh.sb.restws.bean.Users;
import viveksingh.sb.restws.exception.UserNotFoundException;
import viveksingh.sb.restws.repository.UsereDaoService;

/**
 * @author vivek
 *
 */
@RestController
public class UserResource {

	private Logger logger = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	private UsereDaoService userDaoService;

	/**
	 * Retrieve all users.
	 * 
	 * @return
	 */
	@GetMapping(path = "/users")
	public Users retrieveAllUsers() {

		logger.info("Processing GET request for [\"/users] service.");

		final Users users = new Users(userDaoService.findAll());
		
		logger.info("Completed GET request for [\"/users] service.");

		return users;
	}

	/**
	 * Retrieve user with provided user-id.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable Integer id) {

		logger.info("Processing GET request for [\"/users/{id}] service.");

		User user = userDaoService.fineOne(id);

		if (user == null) {
			throw new UserNotFoundException(String.format("UserId : %s", id));
		}

		logger.info("Completed GET request for [\"/users/{id}] service.");

		return user;
	}

	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Integer id) {

		logger.info("Processing DELETE request for [\"/users/{id}] service.");

		User user = userDaoService.delteUserById(id);

		if (user == null) {
			throw new UserNotFoundException(String.format("UserId : %s", id));
		}

		logger.info("Completed DELETE request for [\"/users/{id}] service.");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/**
	 * Save the user.
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {

		logger.info("Processing POST request for [\"/users] service.");

		// Save the user
		final User savedUser = userDaoService.save(user);

		// Create link to newly created user
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		logger.info("Completed POST request for [\"/users] service.");

		// Append newly created user link to response header.
		return ResponseEntity.created(location).build();
	}
}
