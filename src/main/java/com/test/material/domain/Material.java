package com.test.material.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.ParamDef;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@FilterDefs({ @FilterDef(name = "cmperms", parameters = { @ParamDef(name = "st", type = "string") }) })
// @FilterDefs把多个过滤器包起来，@FilterDef 定义过滤器名字，parameters 定义过滤器属性的名字和类型
public class Material {

	@Id
	private String id;
	@NotEmpty(message="材料名称不能为空")
	private String name;
	@NotEmpty(message="参数名称不能为空")
	private String parameter;// 参数
	@NotEmpty(message="存放地点不能为空")
	private String location;// 存放地址
	private Date ctime;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "material")
	@Filter(name = "cmperms", condition = "secondtime=:st") // 调用过滤器，name 过滤器的名字condition="字段名(属性名)=:过滤器属性(:等于sql中占位符)"
	private Set<Record> materialset = new HashSet<Record>();

	@Transient
	private Record record;

	public Record getRecord() {
		try {
			
			record = this.getMaterialset().iterator().next();// 获取 set 中第一个值
			System.out.println(record.getId());
			System.out.println(record.getSecondtime());
		} catch (Exception e) {

		}
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

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
