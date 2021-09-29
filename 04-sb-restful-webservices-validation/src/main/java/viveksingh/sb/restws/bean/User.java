/**
 * 
 */
package viveksingh.sb.restws.bean;

import java.util.Date;

import javax.validation.constraints.Size;

/**
 * @author vivek
 *
 */
public class User {

	private Integer id;

	@Size(min = 2, message = "Name should be mnimum of 2 chars/")
	private String name;

	private Date DateOfBirth;

	/**
	 * Default constructor.
	 */
	public User() {

	}

	/**
	 * @param id
	 * @param name
	 * @param dateOfBirth
	 */
	public User(Integer id, String name, Date dateOfBirth) {
		this.id = id;
		this.name = name;
		DateOfBirth = dateOfBirth;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, DateOfBirth=%s]", id, name, DateOfBirth);
	}
}
