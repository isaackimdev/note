package sample3;

public class UserServiceImpl implements UserService {
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl 생성자 호출");
	}
	@Override
	public void addUser(UserVo vo) {
		System.out.println("addUser(UserVo vo) 메소드 호출");
		System.out.println("이름 : " + vo.getUserName());
	}

}




