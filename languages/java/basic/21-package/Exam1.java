// 패키지 안에 있는 클래스를 쓸 경우 import 시켜주어야 한다.
import study.java.bbs.Article;

public class Exam1 {

	public static void main(String[] args) {
		Article.setCategory("자유게시판");
		Article a1 = new Article(1, "첫번째 글 제목입니다.", "2018-05-02");
		Article a2 = new Article(2, "두번째 글 제목입니다.", "2018-05-02");
		Article a3 = new Article(3, "세번째 글 제목입니다.", "2018-05-02");
		
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
		System.out.println("----------------------------------");
		
		Article.setCategory("공지사항");
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
		
	}

}
