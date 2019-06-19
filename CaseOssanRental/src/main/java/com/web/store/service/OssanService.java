package com.web.store.service;

import java.util.List;

import com.web.store.model.OssanBean;

public interface OssanService {
	
	boolean isExist(String email);
	void save(OssanBean ossanBean);
	boolean ossanExist(String email , String password);
	OssanBean getOssanBean(String email);
	OssanBean getOssanBeanByID(Integer ossanNo);
	void update(OssanBean ossanBean);
	List<OssanBean> getAllOssanBean();
	int getCount();
	List<OssanBean> searchOssan(String keyword);
	
}
