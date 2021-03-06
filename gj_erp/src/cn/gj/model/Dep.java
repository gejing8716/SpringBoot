package cn.gj.model;

/**
 * Dep entity. @author MyEclipse Persistence Tools
 */

public class Dep implements java.io.Serializable {

	private Integer depId;
	private String name;
	private String tel;

	// Constructors

	/** default constructor */
	public Dep() {
	}

	/** full constructor */
	public Dep(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	// Property accessors

	public Integer getDepId() {
		return this.depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}