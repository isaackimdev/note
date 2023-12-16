// object.class 최상위 부모 클래스..

public class QNAArticle extends Article{
	// 답변 추가
	private String answer;
	
	public String toString() {
		System.out.println(super.toString()); // super.부모클래스의 기본함수 호출
		return "질문/답변 [번호=" + getNum() + ",제목 ="
				+ getTitle() + ", 답변=" + answer
				+ "]";
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
