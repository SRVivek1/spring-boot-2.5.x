/**
 * 
 */
package viveksingh.sb.restws.beans;

/**
 * Hello world greeting bean.
 * 
 * @author vivek
 *
 */
public class HelloWorldBean {

	private String message;
	
	public HelloWorldBean(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	
}
