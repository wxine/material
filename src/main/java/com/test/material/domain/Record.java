package com.test.material.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Record {
	@Id
	private String id;
	@ManyToOne
	@JoinColumn(name = "projectid")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "materialid")
	private Material material;
	private String Secondtime = "yes";

	private Date Recordctime;

	public Record() {

	}

	public Record(String id, Project project, Material material, String secondtime, Date recordctime) {
		this.id = id;
		this.project = project;
		this.material = material;
		Secondtime = secondtime;
		Recordctime = recordctime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Date getRecordctime() {
		return Recordctime;
	}

	public void setRecordctime(Date recordctime) {
		Recordctime = recordctime;
	}

	public String getSecondtime() {
		return Secondtime;
	}

	public void setSecondtime(String secondtime) {
		Secondtime = secondtime;
	}

}
