package net.northking.king.auth.king.vo;

/**
 * TbEmploeeProjectId entity. @author MyEclipse Persistence Tools
 */

public class TbEmploeeProjectId implements java.io.Serializable {

	// Fields

	private String employeeId;
	private String projectId;

	// Constructors

	/** default constructor */
	public TbEmploeeProjectId() {
	}

	/** full constructor */
	public TbEmploeeProjectId(String employeeId, String projectId) {
		this.employeeId = employeeId;
		this.projectId = projectId;
	}

	// Property accessors

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbEmploeeProjectId))
			return false;
		TbEmploeeProjectId castOther = (TbEmploeeProjectId) other;

		return ((this.getEmployeeId() == castOther.getEmployeeId()) || (this
				.getEmployeeId() != null
				&& castOther.getEmployeeId() != null && this.getEmployeeId()
				.equals(castOther.getEmployeeId())))
				&& ((this.getProjectId() == castOther.getProjectId()) || (this
						.getProjectId() != null
						&& castOther.getProjectId() != null && this
						.getProjectId().equals(castOther.getProjectId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getEmployeeId() == null ? 0 : this.getEmployeeId()
						.hashCode());
		result = 37 * result
				+ (getProjectId() == null ? 0 : this.getProjectId().hashCode());
		return result;
	}

}