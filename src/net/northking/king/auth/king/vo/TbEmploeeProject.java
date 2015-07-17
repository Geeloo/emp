package net.northking.king.auth.king.vo;

/**
 * TbEmploeeProject entity. @author MyEclipse Persistence Tools
 */

public class TbEmploeeProject implements java.io.Serializable {

	// Fields

	private TbEmploeeProjectId id;

	// Constructors

	/** default constructor */
	public TbEmploeeProject() {
	}

	/** full constructor */
	public TbEmploeeProject(TbEmploeeProjectId id) {
		this.id = id;
	}

	// Property accessors

	public TbEmploeeProjectId getId() {
		return this.id;
	}

	public void setId(TbEmploeeProjectId id) {
		this.id = id;
	}

}