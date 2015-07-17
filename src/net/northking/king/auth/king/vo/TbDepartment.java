package net.northking.king.auth.king.vo;

/**
 * TbDepartment entity. @author MyEclipse Persistence Tools
 */

public class TbDepartment implements java.io.Serializable {

	// Fields

	private String id;
	private String deptId;
	private String deptName;
	private String telephone;
	private String centreId;
	private String centreName;
	private String centreTelephone;

	// Constructors

	

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCentreId() {
		return this.centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public String getCentreName() {
		return this.centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}

	public String getCentreTelephone() {
		return this.centreTelephone;
	}

	public void setCentreTelephone(String centreTelephone) {
		this.centreTelephone = centreTelephone;
	}

}