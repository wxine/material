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
public class Material {

	@Id
	private String id;
	@NotEmpty
	private String name;
	private String parameter;// 参数
	private String location;// 存放地址
	private Date ctime;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "material")
	private Set<Record> materialset = new HashSet<Record>();

	public Material() {

	}

	public Material(String id, String name, String parameter, String location, Date ctime, Set<Record> materialset) {
		this.id = id;
		this.name = name;
		this.parameter = parameter;
		this.location = location;
		this.ctime = ctime;
		this.materialset = materialset;
	}

	public Set<Record> getMaterialset() {
		return materialset;
	}

	public void setMaterialset(Set<Record> materialset) {
		this.materialset = materialset;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

}
