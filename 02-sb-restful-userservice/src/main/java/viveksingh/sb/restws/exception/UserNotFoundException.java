/**
 * 
 */
package viveksingh.sb.restws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author vivek
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2644342800577355780L;

	/**
	 * @param message
	 */
	public UserNotFoundException(String message) {
		super(message);
	}
}
