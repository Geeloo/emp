package net.northking.king.auth.king.vo;

/**
 * TbProjectStatus entity. @author MyEclipse Persistence Tools
 */

public class TbProjectStatus implements java.io.Serializable {

	// Fields

	private String id;
	private String projectId;
	private String rrojectNum;
	private String contractNum;
	private String contractPayStage;
	private Integer payPersent;
	private Integer alsoPay;
	private boolean payStatus;

	// Constructors

	/** default constructor */
	public TbProjectStatus() {
	}

	/** full constructor */
	public TbProjectStatus(String projectId, String rrojectNum,
			String contractNum, String contractPayStage, Integer payPersent,
			Integer alsoPay, boolean payStatus) {
		this.projectId = projectId;
		this.rrojectNum = rrojectNum;
		this.contractNum = contractNum;
		this.contractPayStage = contractPayStage;
		this.payPersent = payPersent;
		this.alsoPay = alsoPay;
		this.payStatus = payStatus;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getRrojectNum() {
		return this.rrojectNum;
	}

	public void setRrojectNum(String rrojectNum) {
		this.rrojectNum = rrojectNum;
	}

	public String getContractNum() {
		return this.contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public String getContractPayStage() {
		return this.contractPayStage;
	}

	public void setContractPayStage(String contractPayStage) {
		this.contractPayStage = contractPayStage;
	}

	public Integer getPayPersent() {
		return this.payPersent;
	}

	public void setPayPersent(Integer payPersent) {
		this.payPersent = payPersent;
	}

	public Integer getAlsoPay() {
		return this.alsoPay;
	}

	public void setAlsoPay(Integer alsoPay) {
		this.alsoPay = alsoPay;
	}

	public boolean getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}

}