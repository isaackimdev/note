import java.io.File;
import java.io.IOException;

public class Exam1 {

	public static void main(String[] args) {
		// 절대경로나 상대경로를 생성자 파라미터로 전달한다.
		// 이클립스에서 상대경로를 사용할 경우, 현재 프로젝트가 기준이 된다.
		File f1 = new File("src/Main01.java");
		System.out.println("f1 = " + f1);
		// 전달된 경로가 파일인지 검사
		// --> 존재하지 않는 파일로 검사할 경우 무조건 false
		boolean is_file = f1.isFile();
		System.out.println("is_file = " + is_file);
		// 전달된 경로가 디렉토리인지 검사
		// --> 존재하지 않는 디렉토리로 검사할 경우 무조건 false
		boolean is_dir = f1.isDirectory();
		System.out.println("is_dir = " + is_dir);
		// 전달된 경로가 숨김형태인지 검사
		// --> 존재하지 않는 파일로 검사할 경우 무조건 false
		boolean is_hidden = f1.isHidden();
		System.out.println("is_hidden = " + is_hidden);
		// 절대 경로값을 추출
		String abs = f1.getAbsolutePath();
		System.out.println("절대경로 : " + abs);
		// 생성자에 전달된 파일이나 디렉토리가 물리적으로 존재하는지를 검사
		boolean is_exist = f1.exists();
		System.out.println("존재여부 : " + is_exist);
		// 파일만들기
		try {
			f1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		is_exist = f1.exists();
		System.out.println("존재여부 : " + is_exist);
		// 파일없애기
		f1.delete();
		is_exist = f1.exists();
		System.out.println("존재여부 : " + is_exist);
		System.out.println("-------------------------");
		
		// 디렉토리(폴더) 정보 객체 생성
		File f2 = new File("a/b/c/target");
		System.out.println("isFile = " + f2.isFile());
		System.out.println("isDirectory = " + f2.isDirectory());
		System.out.println("isHidden = " + f2.isHidden());
		System.out.println("절대경로 : " + f2.getAbsolutePath());
		System.out.println("존재여부 : " + f2.exists());
		
		// 디렉토리 만들기
		f2.mkdir();
		System.out.println("존재여부 : " + f2.exists());
		// 경로에 따른 디렉토리 생성
		f2.mkdirs();
		System.out.println("존재여부 : " + f2.exists());
		System.out.println("--------------------------");
		// 마지막 "/" 이후 단어를 리턴
		System.out.println(f1.getName());
		System.out.println(f2.getName());
		System.out.println("--------------------------");
		
		// 처음부터 마지막 "/" 직전까지 리턴
		System.out.println(f1.getParent());
		System.out.println(f2.getParent());
		System.out.println("--------------------------");
		
		// 삭제 시도후, 성공시 true 실패시 false
		boolean del_ok = f2.delete();
		System.out.println("삭제성공여부 : " + del_ok);
	}
}







