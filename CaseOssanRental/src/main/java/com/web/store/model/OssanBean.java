package com.web.store.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

@Entity

public class OssanBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer ossanNo;
	private String email;
	private String password;
	
	private String name;
	private String uniqueId;
	private Date birthday;
	private String phone;
	private Timestamp registerTime;
	private String address;	
	private String nickname;
	
	private Blob ossanImage;
	private String fileName;	
	private String quote;
	
	

	
	@Lob
	private Clob intro;
	private String sIntro;
	private String area;
	private Set<ArticleBean> articleBean;
	
	private MultipartFile introImage;
	
	
	
	
	public OssanBean(Integer ossanNo, String email, String password, String name, String uniqueId, Date birthday,
			String phone, Timestamp registerTime, String address, String nickname, Blob ossanImage, String fileName,
			String quote, Clob intro, String area) {
		super();
		this.ossanNo = ossanNo;
		this.email = email;
		this.password = password;
		this.name = name;
		this.uniqueId = uniqueId;
		this.birthday = birthday;
		this.phone = phone;
		this.registerTime = registerTime;
		this.address = address;
		this.nickname = nickname;
		this.ossanImage = ossanImage;
		this.fileName = fileName;
		this.quote = quote;
		this.intro = intro;
		this.area = area;
	}

	@OneToMany(mappedBy="ossanBean" , cascade = CascadeType.ALL)
	public Set<ArticleBean> getArticleBean() {
		return articleBean;
	}

	public void setArticleBean(Set<ArticleBean> articleBean) {
		this.articleBean = articleBean;
	}

	public OssanBean() {
	
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getOssanNo() {
		return ossanNo;
	}

	public void setOssanNo(Integer ossanNo) {
		this.ossanNo = ossanNo;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Blob getOssanImage() {
		return ossanImage;
	}

	public void setOssanImage(Blob ossanImage) {
		this.ossanImage = ossanImage;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public Clob getIntro() {
		return intro;
	}

	public void setIntro(Clob intro) {
		this.intro = intro;
	}
	
	@Transient
	public String getsIntro() {
		return sIntro;
	}

	public void setsIntro(String sIntro) {
		this.sIntro = sIntro;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	@XmlTransient
	@Transient
	public MultipartFile getIntroImage() {
		return introImage;
	}

	public void setIntroImage(MultipartFile introImage) {
		this.introImage = introImage;
	}
	
	
	

	
	
	

}