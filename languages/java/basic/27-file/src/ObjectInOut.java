import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ObjectInOut {
	public int write(String fname, List<Student> list) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		int objectNumber = 0;
		
		try {
			fos = new FileOutputStream(fname);
			oos = new ObjectOutputStream(fos);
			
			objectNumber = list.size();
			oos.writeInt(objectNumber);
			System.out.println(objectNumber + "개의 Student가 입력됨");
			
			for(int i=0; i<objectNumber; i++) {
				oos.writeInt(i);
				oos.writeObject(list.get(i));
				// 출력버퍼 비우기
				oos.flush();
				System.out.println(i + "번째의 Student가 저장됨");
			}
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + fname);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 저장 실패 >> " + fname);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + fname);
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) oos.close();
				if(fos != null) fos.close();
			} catch(IOException e) {
				System.out.println("[ERROR] 파일 닫기 실패");
			}
		}
		
		return objectNumber;
	}
	
	public void read(String fname) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fname);
			ois = new ObjectInputStream(fis);
			
			int objectNumber = ois.readInt();
			System.out.println(objectNumber + " 개의 Student를 읽음");
			
			for(int i=0; i<objectNumber; i++) {
				System.out.print(ois.readInt() + "번째");
				Student student = (Student)ois.readObject();
				System.out.println(student.toString());
				//System.out.println(ois.readObject().toString());
			}
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + fname);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 읽기 실패 >> " + fname);
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + fname);
			//e.printStackTrace();
		} finally {
			try {
				if(ois != null) ois.close();
				if(fis != null) fis.close();
			} catch (IOException e) {
					System.out.println("[Error] 파일 닫기 에러");
			}
		}
	}
}



