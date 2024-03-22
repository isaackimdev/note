package member.controller;

import member.bean.MemberDTO;

public interface MemberService {
	public int write(MemberDTO memberDTO);
	public int modify(MemberDTO memberDTO);
	public MemberDTO getMember(String id);
	public String login(String id, String pwd);
	public boolean isExistId(String id) ;
}
