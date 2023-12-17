
public class Practice1 {

	public static void main(String[] args) {
		String link = new String("D:/photo/2016/travel/food.jpg");	// 라는 파일
		String data = "D:/photo/2016/travel/food.jpg";
		// 위 파일의 경로를 data 라는 객체로 생성한 뒤에,
		// 다음의 형태로 출력하시오
		// split() 메소드 사용 금지
		
		//파일이름 ,확장자, 폴더이름 자르기
		String fileName= new String();
		String ext="", folderName="";
		
		int slash = link.lastIndexOf("/");
		int dot =data.lastIndexOf(".");
		System.out.println("slash 위치 : " + slash);
		System.out.println("dat 위치 : " + dot);
		System.out.println();
		
		fileName = link.substring(slash+1,dot);
		ext = link.substring(dot+1);
		folderName = link.substring(0,20);
		
		// output
		System.out.println("파일 이름 : " + fileName);
		System.out.println("확 장 자 : " + ext);
		System.out.println("folderName : " + folderName);
		
	}

}
