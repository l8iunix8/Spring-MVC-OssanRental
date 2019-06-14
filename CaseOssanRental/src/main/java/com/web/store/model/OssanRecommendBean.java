package com.web.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OssanRecommendBean {
	private Integer id;
	private Integer recommend;	
	private OssanBean ossanBean;
	
	public OssanRecommendBean(Integer Id,Integer recommend,OssanBean ossanBean) {
		super();
		this.id = Id;
		this.recommend = recommend;
		this.ossanBean = ossanBean;
	}
	public OssanRecommendBean() {};
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	
	@OneToOne
	@JoinColumn(name="FK_ossanNo")
	public OssanBean getOssanBean() {
		return ossanBean;
	}
	public void setOssanBean(OssanBean ossanBean) {
		this.ossanBean = ossanBean;
	}
	
	
	
}
