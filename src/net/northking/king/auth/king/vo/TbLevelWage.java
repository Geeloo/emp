package net.northking.king.auth.king.vo;

/**
 * TbLevelWage entity. @author MyEclipse Persistence Tools
 */

public class TbLevelWage implements java.io.Serializable {

	// Fields

	private String id;
	private String num;
	private String workType;
	private String postLevel;
	private Integer wagesOnline;

	// Constructors

	/** default constructor */
	public TbLevelWage() {
	}

	/** full constructor */
	public TbLevelWage(String num, String workType, String postLevel,
			Integer wagesOnline) {
		this.num = num;
		this.workType = workType;
		this.postLevel = postLevel;
		this.wagesOnline = wagesOnline;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getWorkType() {
		return this.workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getPostLevel() {
		return this.postLevel;
	}

	public void setPostLevel(String postLevel) {
		this.postLevel = postLevel;
	}

	public Integer getWagesOnline() {
		return this.wagesOnline;
	}

	public void setWagesOnline(Integer wagesOnline) {
		this.wagesOnline = wagesOnline;
	}

}