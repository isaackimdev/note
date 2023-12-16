
public class Exam2 {
	
	public static void main(String[] args) {
		FileArticle fileArticle = new FileArticle();
		fileArticle.setNum(1);
		fileArticle.setTitle("첫번째 자료입니다.");
		fileArticle.setFileName("java.ppt");
		System.out.println(fileArticle.toString());
		
		QNAArticle qna = new QNAArticle();
		qna.setNum(1);
		qna.setTitle("첫번째 질문입니다.");
		qna.setAnswer("첫번째 답변입니다.");
		System.out.println(qna.toString());	// 오버라이딩 없으면 부모에게 덮어씀
		
		
	}
}
