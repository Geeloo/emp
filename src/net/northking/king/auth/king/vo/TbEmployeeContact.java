package net.northking.king.auth.king.vo;

/**
 * TbEmployeeContact entity. @author MyEclipse Persistence Tools
 */

public class TbEmployeeContact implements java.io.Serializable {

	// Fields

	private String id;
	private String employeeId;
	private long telephone;
	private String address;
	private String email;

	// Constructors

	/** default constructor */
	public TbEmployeeContact() {
	}

	/** full constructor */
	public TbEmployeeContact(String employeeId, long telephone, String address,
			String email) {
		this.employeeId = employeeId;
		this.telephone = telephone;
		this.address = address;
		this.email = email;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public long getTelephone() {
		return this.telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}