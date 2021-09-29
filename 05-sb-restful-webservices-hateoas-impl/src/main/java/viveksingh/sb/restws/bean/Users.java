/**
 * 
 */
package viveksingh.sb.restws.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

/**
 * @author vivek
 *
 */
public class Users extends RepresentationModel<Users> {

	private List<User> users;

	/**
	 * @param users
	 */
	public Users(List<User> users) {
		super();
		this.users = users;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		if (users == null) {
			users = new ArrayList<>();
		}

		return users;
	}
}
