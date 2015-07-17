package net.northking.king.auth.king.vo;

import java.util.Date;

/**
 * TbProject entity. @author MyEclipse Persistence Tools
 */

public class TbProject implements java.io.Serializable {

	// Fields

	private String id;
	private String num;
	private String address;
	private Date startDate;
	private Date endDate;
	private long projectBudget;
	private String departmentId;
	private String customerId;
	private String officesId;
	private String projectManagerPersonId;
	private String projectManagerPersonTel;
	private String demandManagerPersonId;
	private String demandManagerPersonTel;
	private String secondPartyManagerId;
	private String secondPartyManagerTel;
	private boolean projectStatus;
	private long contractMoney;
	private String businessDeputy;
	private String projectName;

	// Constructors

	/** default constructor */
	public TbProject() {
	}

	/** full constructor */
	public TbProject(String num, String address, Date startDate, Date endDate,
			long projectBudget, String departmentId, String customerId,
			String officesId, String projectManagerPersonId,
			String projectManagerPersonTel, String demandManagerPersonId,
			String demandManagerPersonTel, String secondPartyManagerId,
			String secondPartyManagerTel, boolean projectStatus,
			long contractMoney, String businessDeputy, String projectName) {
		this.num = num;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectBudget = projectBudget;
		this.departmentId = departmentId;
		this.customerId = customerId;
		this.officesId = officesId;
		this.projectManagerPersonId = projectManagerPersonId;
		this.projectManagerPersonTel = projectManagerPersonTel;
		this.demandManagerPersonId = demandManagerPersonId;
		this.demandManagerPersonTel = demandManagerPersonTel;
		this.secondPartyManagerId = secondPartyManagerId;
		this.secondPartyManagerTel = secondPartyManagerTel;
		this.projectStatus = projectStatus;
		this.contractMoney = contractMoney;
		this.businessDeputy = businessDeputy;
		this.projectName = projectName;
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getProjectBudget() {
		return this.projectBudget;
	}

	public void setProjectBudget(long projectBudget) {
		this.projectBudget = projectBudget;
	}

	public String getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getOfficesId() {
		return this.officesId;
	}

	public void setOfficesId(String officesId) {
		this.officesId = officesId;
	}

	public String getProjectManagerPersonId() {
		return this.projectManagerPersonId;
	}

	public void setProjectManagerPersonId(String projectManagerPersonId) {
		this.projectManagerPersonId = projectManagerPersonId;
	}

	public String getProjectManagerPersonTel() {
		return this.projectManagerPersonTel;
	}

	public void setProjectManagerPersonTel(String projectManagerPersonTel) {
		this.projectManagerPersonTel = projectManagerPersonTel;
	}

	public String getDemandManagerPersonId() {
		return this.demandManagerPersonId;
	}

	public void setDemandManagerPersonId(String demandManagerPersonId) {
		this.demandManagerPersonId = demandManagerPersonId;
	}

	public String getDemandManagerPersonTel() {
		return this.demandManagerPersonTel;
	}

	public void setDemandManagerPersonTel(String demandManagerPersonTel) {
		this.demandManagerPersonTel = demandManagerPersonTel;
	}

	public String getSecondPartyManagerId() {
		return this.secondPartyManagerId;
	}

	public void setSecondPartyManagerId(String secondPartyManagerId) {
		this.secondPartyManagerId = secondPartyManagerId;
	}

	public String getSecondPartyManagerTel() {
		return this.secondPartyManagerTel;
	}

	public void setSecondPartyManagerTel(String secondPartyManagerTel) {
		this.secondPartyManagerTel = secondPartyManagerTel;
	}

	public boolean getProjectStatus() {
		return this.projectStatus;
	}

	public void setProjectStatus(boolean projectStatus) {
		this.projectStatus = projectStatus;
	}

	public long getContractMoney() {
		return this.contractMoney;
	}

	public void setContractMoney(long contractMoney) {
		this.contractMoney = contractMoney;
	}

	public String getBusinessDeputy() {
		return this.businessDeputy;
	}

	public void setBusinessDeputy(String businessDeputy) {
		this.businessDeputy = businessDeputy;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}