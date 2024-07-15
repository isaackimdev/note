package member.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.bean.MemberDTO;
@Repository	// 어노테이션으로 객체 인식 시켜줌
public class MemberDAO3 {
	@Autowired	// bean객체로 되어 있는 dataPull을 얻어옴
	private SqlSessionTemplate sqlSession;
	
	public int write(MemberDTO memberDTO) {
		return sqlSession.insert("mybatis.member.memberInsert", memberDTO);
	}
	
	public int modify(MemberDTO memberDTO) {
		return sqlSession.update("mybatis.member.memberModify", memberDTO);
	}
	
	// 한명의 정보 얻어오기
	public MemberDTO getMember(String id) {
		return sqlSession.selectOne("mybatis.member.memberGet", id);
	}
	
	// 로그인
	public String login(String id, String pwd) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		return sqlSession.selectOne("mybatis.member.memberLogin", map);
	}
	// 아이디가 존재하는지 체크
	public boolean isExistId(String id) {
		boolean exist = false;
		if(sqlSession.selectOne("mybatis.member.isExistId", id) != null) {
			exist = true;
		}
		return exist;
	}
}














