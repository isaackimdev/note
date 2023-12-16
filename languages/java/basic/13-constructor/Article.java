/** 하나의 게시물을 표현하기 위한 Java Beans
* JavaBeans 클래스
 => 자바빈 규약에 맞추어 만들어진 클래스
 => 멤버변수 private
  - 멤버함수는 public
      매개변수없는 생성자가 반드시 있어야 한다.
      각각의 멤버변수마다 getter / setter 를 한쌍을 만든다.
 => 용도 : 여러개의 변수를 묶어서 관리하기 위해서 
*/
public class Article {
	private int seq;		// 글 번호
	private String subject;	// 글 제목
	private String content; // 글 내용
	private String writer;  // 작성자
	private int hit;		// 조회수
	private String regDate;	// 작성일시

	public Article () {
		this.seq=0;			// 글 번호
		this.subject="";	// 글 제목
		this.content=""; 	// 글 내용
		this.writer="";  	// 작성자
		this.hit=0;			// 조회수
		this.regDate="";	// 작성일시
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getSeq() {
		return seq;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public String getWriter() {
		return writer;
	}

	public int getHit() {
		return hit;
	}

	public String getRegDate() {
		return regDate;
	}
	
	

	
}


