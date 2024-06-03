package com.side.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.side.bean.DateVo;

@Repository
public class TestDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int insert (DateVo dateVo) {
		return sqlSession.insert("mb_map.insert", dateVo);
	}
	
	public DateVo select () {
		return sqlSession.selectOne("mb_map.select");
	}
	
}
