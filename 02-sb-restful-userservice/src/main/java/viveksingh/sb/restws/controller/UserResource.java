/**
 * 
 */
package viveksingh.sb.restws.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import viveksingh.sb.restws.bean.User;
import viveksingh.sb.restws.exception.UserNotFoundException;
import viveksingh.sb.restws.repository.UsereDaoService;

/**
 * @author vivek
 *
 */
@RestController
public class UserResource {

	@Autowired
	private UsereDaoService userDaoService;

	/**
	 * Retrieve all users.
	 * 
	 * @return
	 */
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAll();
	}

	/**
	 * Retrieve user with provided user-id.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable Integer id) {
		User user = userDaoService.fineOne(id);
		
		if (user == null) {
			throw new UserNotFoundException(String.format("UserId : %s", id));
		}
		
		return user;
	}

	/**
	 * Save the user.
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {

		// Save the user
		final User savedUser = userDaoService.save(user);

		// Create link to newly created user
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		// Append newly created user link to response header.
		return ResponseEntity.created(location).build();
	}
}
