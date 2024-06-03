package com.side.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.side.bean.DateVo;
import com.side.dao.TestDAO;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	TestDAO dao;
	
	@Override
	public int insert(DateVo dateVo) {
		return dao.insert(dateVo);
	}

	@Override
	public DateVo select() {
		return dao.select();
	}

}
