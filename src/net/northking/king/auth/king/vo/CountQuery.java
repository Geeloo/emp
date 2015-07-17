package net.northking.king.auth.king.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * ClassName: CountQuery 
 * @Description: 统计查询类
 * @author wanglei
 * @date 2015-6-12
 */
public class CountQuery {

	private String id;
	private String num;
	private String name;
	private Date beginDate;
	private Date endDate;
	private BigDecimal contractBudget;
	private BigDecimal profit;
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
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public BigDecimal getContractBudget() {
		return contractBudget;
	}
	public void setContractBudget(BigDecimal contractBudget) {
		this.contractBudget = contractBudget;
	}
	public BigDecimal getProfit() {
		return profit;
	}
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
