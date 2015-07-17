package net.northking.king.auth.king.vo;

import java.util.Date;

/**
 * 
 * ClassName: Project 
 * @Description: 项目实体类
 * @author wanglei
 * @date 2015-6-15
 */
public class Project {

	private String id;
	private String num;
	private String name;
	private Date startDate;
	private Date endDate;
	private String contractBudget;
	private String profit;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getContractBudget() {
		return contractBudget;
	}
	public void setContractBudget(String contractBudget) {
		this.contractBudget = contractBudget;
	}
	public String getProfit() {
		return profit;
	}
	public void setProfit(String profit) {
		this.profit = profit;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
