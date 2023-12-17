package study.java.bbs; // 어디에 있는지, 어떤 패키지 안에 있는지 알려달란 명령어
						// 없을시에 오류가 뜨며, src에 있는 것으로 인지함.
public class Article {
	// 전체 게시물의 수를 표현하기 위한 데이터
	private static int count = 0;
	// 모든 게시물은 하나의 카테고리 안에 존재한다고 가정한다.
	// 게시물의 분류를 구별하기 위한 데이터
	private static String category;
	private int num;		// 글 번호
	private String title;	// 글 제목
	private String regDate; // 작성일시
	
	public Article (int num, String title, String regDate) {
		this.num = num;
		this.title = title;
		this.regDate = regDate;
		// 이 클래스에 대한 객체 생성 -> 게시물 신규 등록
		// 게시물이 새로 등록될 때마가, 전체 글 수를 의미하는 count 변수가 1씩 증가한다.
		// 전체 게시물 수는 모든 객체가 공유하는 값이므로 static으로 생성되어야 한다.
		count++;	
	}
	
	public String toString() {
		return "글 분류=" + category + ", 전체 글수 = " + count + ", Article [num="
				+num +", title="+title +",regDate="+regDate+"]";
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Article.count = count;
	}

	public static String getCategory() {
		return category;
	}

	public static void setCategory(String category) {
		Article.category = category;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
