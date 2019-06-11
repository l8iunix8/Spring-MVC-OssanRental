package com.web.store.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class MemberBean implements Serializable{
	private Integer memberNo;
	private String email;
	private String password;	
	private String name;
	private String uniqueId;
	private Date birthday;
	private String phone;
	private Timestamp registerTime;
	private String address;	
	private Set<OrderBean> orderBean;
	public MemberBean(Integer ossanNo, String email, String password, String name, String uniqueId, Date birthday,
			String phone, Timestamp registerTime, String address) {
		super();
		this.memberNo = ossanNo;
		this.email = email;
		this.password = password;
		this.name = name;
		this.uniqueId = uniqueId;
		this.birthday = birthday;
		this.phone = phone;
		this.registerTime = registerTime;
		this.address = address;
	}
	public MemberBean() {}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getOssanNo() {
		return memberNo;
	}
	public void setOssanNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

	@OneToMany(mappedBy="memberBean")
	public Set<OrderBean> getOrderBean() {
		return orderBean;
	}
	public void setOrderBean(Set<OrderBean> orderBean) {
		this.orderBean = orderBean;
	};
	
	
	
}
