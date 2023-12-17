import helper.FileHelper;

public class Exam4 {

	public static void main(String[] args) {
		String encType = "MS949";
		//String filePath = "myfile.txt";
		String filePath = "src/Exam1.java";
		String content = "안녕하세요. 자바 프로그래밍";
		
//		boolean result = 
//				FileHelper.getInstance().writeString(filePath, content, encType);
//		if(!result) {
//			System.out.println("파일 저장에 실패했습니다.");
//			return;
//		}
		
		String read = FileHelper.getInstance().readString(filePath, encType);
		System.out.println(read);
	}

}



