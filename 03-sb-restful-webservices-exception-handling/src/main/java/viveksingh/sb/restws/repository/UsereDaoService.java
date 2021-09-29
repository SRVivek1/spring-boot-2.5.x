/**
 * 
 */
package viveksingh.sb.restws.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import viveksingh.sb.restws.bean.User;

/**
 * @author vivek
 *
 */
@Component
public class UsereDaoService {

	Logger logger = LoggerFactory.getLogger(UsereDaoService.class);

	private static List<User> users = new ArrayList<>();

	private static int userCount;

	static {
		users.add(new User(1, "Vivek", new Date()));
		users.add(new User(2, "Rahul", new Date()));
		users.add(new User(3, "Mohit", new Date()));

		userCount = 3;
	}

	// save a user
	public User save(User user) {
		int uc = ++userCount;
		if (user.getId() == null) {
			user.setId(uc);
		}
		users.add(user);

		return user;
	}

	/**
	 * Return the users list.
	 * 
	 * @return
	 */
	public List<User> findAll() {
		return users;
	}

	/**
	 * Find the user with provided userId.
	 * 
	 * @param id
	 * @return
	 */
	public User fineOne(int userId) {
		Optional<User> result = users.stream().filter(user -> user.getId() == userId).findFirst();

		if (result.isPresent()) {
			logger.info("User found with userId : {}, name: {}", userId, result.get().getName());
			return result.get();
		}

		// User not found
		logger.error("No user found with id {}.", userId);
		return null;
	}

	/**
	 * Deletes the user for provided user Id, return null if user not found.
	 * 
	 * @param id
	 * @return
	 */
	public User delteUserById(Integer id) {

		final Iterator<User> iterator = users.iterator();

		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
