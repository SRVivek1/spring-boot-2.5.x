/**
 * 
 */
package viveksingh.sb.restws.bean;

import java.util.Date;

/**
 * @author vivek
 *
 */
public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private String details;

	/**
	 * @param timestamp
	 * @param message
	 * @param details
	 */
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
}
