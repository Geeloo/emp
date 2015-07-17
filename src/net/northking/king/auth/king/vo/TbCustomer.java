package net.northking.king.auth.king.vo;

/**
 * TbCustomer entity. @author MyEclipse Persistence Tools
 */

public class TbCustomer implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String telephone;
	private String address;
	private String financialField;
	private String fax;
	private String email;
	private String contactPerson;
	private String num;

	// Constructors

	/** default constructor */
	public TbCustomer() {
	}

	/** full constructor */
	public TbCustomer(String name, String telephone, String address,
			String financialField, String fax, String email,
			String contactPerson, String num) {
		this.name = name;
		this.telephone = telephone;
		this.address = address;
		this.financialField = financialField;
		this.fax = fax;
		this.email = email;
		this.contactPerson = contactPerson;
		this.num = num;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFinancialField() {
		return this.financialField;
	}

	public void setFinancialField(String financialField) {
		this.financialField = financialField;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

}