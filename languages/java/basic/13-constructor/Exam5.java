
public class Exam5 {
	public static void main(String[] args) {
		
		Article ar = new Article();
		
		ar.setSeq(1);
		ar.setSubject("테스트 게시물");
		ar.setContent("java beans를 테스트 합니다.");
		ar.setWriter("자바학생");
		ar.setHit(123);
		ar.setRegDate("2016-06-07");
		
		System.out.println(ar.getSeq());
		System.out.println(ar.getSubject());
		System.out.println(ar.getContent());
		System.out.println(ar.getWriter());
		System.out.println(ar.getHit());
		System.out.println(ar.getRegDate());
		
	}

}
