package com.web.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.dao.OssanDao;
import com.web.store.model.OssanBean;
import com.web.store.service.OssanService;

@Service
@Transactional
public class OssanServiceImpl implements OssanService {
	@Autowired
	OssanDao dao;

	@Override
	public boolean isExist(String email) {
		return dao.isExist(email);
	}

	@Override
	public void save(OssanBean ossanBean) {
		dao.save(ossanBean);
	}

	@Override
	public boolean ossanExist(String email, String password) {
		return dao.ossanExist(email, password);
	}

	@Override
	public OssanBean getOssanBean(String email) {
		return dao.getOssanBean(email);
	}

	@Override
	public void update(OssanBean ossanBean) {
		dao.update(ossanBean);
		
	}

	@Override
	public List<OssanBean> getAllOssanBean() {		
		return dao.getAllOssanBean();
	}

	@Override
	public OssanBean getOssanBeanByID(Integer ossanNo) {
		return dao.getOssanBeanByID(ossanNo);
	}

	@Override
	public int getCount() {
		
		return dao.getCount();
	}

	@Override
	public List<OssanBean> searchOssan(String keyword) {
		return dao.searchOssan(keyword);
	}
	
}
