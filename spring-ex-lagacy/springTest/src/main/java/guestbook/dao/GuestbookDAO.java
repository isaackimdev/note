package guestbook.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import guestbook.bean.GuestbookDTO;

@Repository
public class GuestbookDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	// 게시글 작성 처리
	public int guestbookWrite(GuestbookDTO guestbookDTO) {
		System.out.println("sqlSession = "+ sqlSession);
		return sqlSession.insert("mybatis.guestbook.guestbookWrite", guestbookDTO);
	}
	
	// 게시글 목록 보기
	public List<GuestbookDTO> guestbookList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.guestbook.guestbookList", map);
	}
	
	// 글 수 얻어오기
	public int getTotalA() {	//Total Article number
		return sqlSession.selectOne("mybatis.guestbook.getTotalA");
	}
}
