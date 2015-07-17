package net.northking.king.auth.king.vo;

import java.util.Date;

/**
 * TbEmployIncome entity. @author MyEclipse Persistence Tools
 */

public class TbEmployIncome implements java.io.Serializable {

	// Fields

	private String id;
	private Integer employeeIncome;
	private Integer unitPrice;
	private Date beginDate;
	private Integer endDate;
	private String employeeId;
	private String employeeNum;
	private String projectId;
	private String postLevel;

	// Constructors

	/** default constructor */
	public TbEmployIncome() {
	}

	/** full constructor */
	public TbEmployIncome(Integer employeeIncome, Integer unitPrice,
			Date beginDate, Integer endDate, String employeeId,
			String employeeNum, String projectId, String postLevel) {
		this.employeeIncome = employeeIncome;
		this.unitPrice = unitPrice;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.employeeId = employeeId;
		this.employeeNum = employeeNum;
		this.projectId = projectId;
		this.postLevel = postLevel;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getEmployeeIncome() {
		return this.employeeIncome;
	}

	public void setEmployeeIncome(Integer employeeIncome) {
		this.employeeIncome = employeeIncome;
	}

	public Integer getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Integer getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeNum() {
		return this.employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getPostLevel() {
		return this.postLevel;
	}

	public void setPostLevel(String postLevel) {
		this.postLevel = postLevel;
	}

}