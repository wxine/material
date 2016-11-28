package com.test.material.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Project {
	@Id
	private String id;
	@NotEmpty(message = "项目名不能为空")
	private String pname;
	@NotEmpty(message = "密码不能为空")
	private String password;
	private Date ctime;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "project")
	private Set<Record> projectset = new HashSet<Record>();

	public Project() {

	}

	public Project(String id, String pname, String password, Date ctime, Set<Record> projectset) {
		super();
		this.id = id;
		this.pname = pname;
		this.password = password;
		this.ctime = ctime;
		this.projectset = projectset;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Set<Record> getProjectset() {
		return projectset;
	}

	public void setProjectset(Set<Record> projectset) {
		this.projectset = projectset;
	}

}
