
public class FileArticle extends Article{
	// 파일 이름 추가
	private String fileName;

	public String toString() {
		return "자료실 [번호=" + getNum() + ", 제목 ="
				+ getTitle() + ", 첨부파일=" + fileName
				+ "]";
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
