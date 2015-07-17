package net.northking.king.auth.king.vo;

/**
 * TbEmployeeCost entity. @author MyEclipse Persistence Tools
 */

public class TbEmployeeCost implements java.io.Serializable {

	// Fields

	private String id;
	private String employeeId;
	private Integer wage;
	private Integer mustAttendanceDays;
	private Integer achievements;
	private Integer five;
	private Integer stationOld;
	private Integer taxation;
	private String pool;
	private Integer unused;
	private long month;
	private String employeeNum;
	private String sameMonthProfit;
	private String sameMonthProfitMargin;
	private String actualAttendanceDays;
	private long sameMonthInconme;
	private Integer subsidy;
	private Integer activityFee;
	private Integer overtimePay;
	private Integer rent;

	// Constructors

	/** default constructor */
	public TbEmployeeCost() {
	}

	/** full constructor */
	public TbEmployeeCost(String employeeId, Integer wage,
			Integer mustAttendanceDays, Integer achievements, Integer five,
			Integer stationOld, Integer taxation, String pool, Integer unused,
			long month, String employeeNum, String sameMonthProfit,
			String sameMonthProfitMargin, String actualAttendanceDays,
			long sameMonthInconme, Integer subsidy, Integer activityFee,
			Integer overtimePay, Integer rent) {
		this.employeeId = employeeId;
		this.wage = wage;
		this.mustAttendanceDays = mustAttendanceDays;
		this.achievements = achievements;
		this.five = five;
		this.stationOld = stationOld;
		this.taxation = taxation;
		this.pool = pool;
		this.unused = unused;
		this.month = month;
		this.employeeNum = employeeNum;
		this.sameMonthProfit = sameMonthProfit;
		this.sameMonthProfitMargin = sameMonthProfitMargin;
		this.actualAttendanceDays = actualAttendanceDays;
		this.sameMonthInconme = sameMonthInconme;
		this.subsidy = subsidy;
		this.activityFee = activityFee;
		this.overtimePay = overtimePay;
		this.rent = rent;
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

	public Integer getWage() {
		return this.wage;
	}

	public void setWage(Integer wage) {
		this.wage = wage;
	}

	public Integer getMustAttendanceDays() {
		return this.mustAttendanceDays;
	}

	public void setMustAttendanceDays(Integer mustAttendanceDays) {
		this.mustAttendanceDays = mustAttendanceDays;
	}

	public Integer getAchievements() {
		return this.achievements;
	}

	public void setAchievements(Integer achievements) {
		this.achievements = achievements;
	}

	public Integer getFive() {
		return this.five;
	}

	public void setFive(Integer five) {
		this.five = five;
	}

	public Integer getStationOld() {
		return this.stationOld;
	}

	public void setStationOld(Integer stationOld) {
		this.stationOld = stationOld;
	}

	public Integer getTaxation() {
		return this.taxation;
	}

	public void setTaxation(Integer taxation) {
		this.taxation = taxation;
	}

	public String getPool() {
		return this.pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public Integer getUnused() {
		return this.unused;
	}

	public void setUnused(Integer unused) {
		this.unused = unused;
	}

	public long getMonth() {
		return this.month;
	}

	public void setMonth(long month) {
		this.month = month;
	}

	public String getEmployeeNum() {
		return this.employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getSameMonthProfit() {
		return this.sameMonthProfit;
	}

	public void setSameMonthProfit(String sameMonthProfit) {
		this.sameMonthProfit = sameMonthProfit;
	}

	public String getSameMonthProfitMargin() {
		return this.sameMonthProfitMargin;
	}

	public void setSameMonthProfitMargin(String sameMonthProfitMargin) {
		this.sameMonthProfitMargin = sameMonthProfitMargin;
	}

	public String getActualAttendanceDays() {
		return this.actualAttendanceDays;
	}

	public void setActualAttendanceDays(String actualAttendanceDays) {
		this.actualAttendanceDays = actualAttendanceDays;
	}

	public long getSameMonthInconme() {
		return this.sameMonthInconme;
	}

	public void setSameMonthInconme(long sameMonthInconme) {
		this.sameMonthInconme = sameMonthInconme;
	}

	public Integer getSubsidy() {
		return this.subsidy;
	}

	public void setSubsidy(Integer subsidy) {
		this.subsidy = subsidy;
	}

	public Integer getActivityFee() {
		return this.activityFee;
	}

	public void setActivityFee(Integer activityFee) {
		this.activityFee = activityFee;
	}

	public Integer getOvertimePay() {
		return this.overtimePay;
	}

	public void setOvertimePay(Integer overtimePay) {
		this.overtimePay = overtimePay;
	}

	public Integer getRent() {
		return this.rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}

}