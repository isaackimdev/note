package score;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInOut2 {
	/**
	 * 주어진 경로에 data 값을 기록하고 저장한다.
	 * @param fileName - 저장할 파일 이름
	 * @param list - 저장할 내용을 담을 List 클래스
	 * @return boolean - 성공시 true, 실패시 false
	 */
	public boolean write(String fileName, List<ScoreVO> list) {
		// 저장 했다 안했다고 판단을 해야 하기에, void 에서 boolean 함수로 줌.
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		int objectNumber = 0;
		boolean result = false;
		
		try {
			fos = new FileOutputStream(fileName);
			oos= new ObjectOutputStream(fos);
			objectNumber = list.size();
			oos.writeInt(objectNumber);
			
			for(int i=0; i<objectNumber; i++) {
				oos.writeObject(list.get(i));
				oos.flush(); // 출력 한 값을 비우라고 함.
			}
			
			result = true;
			
		} catch (FileNotFoundException e) {
			System.out.println("[error] 저장경로 찾을 수 없음 >>" + fileName);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[error] 파일 저장 실패 >>" + fileName);
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[error] 알 수 없는 애러 >>" + fileName);
			//e.printStackTrace();
		} finally {
			try {
				if (oos!=null) oos.close();
				if (fos!=null) fos.close();
				
			} catch (IOException e) {
				System.out.println(" [error] 파일 닫기 실패");
			}
			
		}
		return result;
	}
	/**
	 * 주어진 경로의 파일을 일고, 내용을 List로 리턴한다.
	 * @param fileName - 읽어야 할 파일의 경로이름
	 * @param List<ScoreVO> - 읽혀진 내용
	 */
	public List<ScoreVO> read(String fileName) {
		List<ScoreVO> list = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			list = new ArrayList<ScoreVO>();
			
			int objectNumber = ois.readInt();
			
			for(int i=0; i<objectNumber; i++) {
				ScoreVO scoreVO = (ScoreVO)ois.readObject();
				list.add(scoreVO);
			}
		} catch (FileNotFoundException e) {
			System.out.println("[error] 저장경로 찾을 수 없음 >>" + fileName);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[error] 파일 읽기 실패 >>" + fileName);
			//e.printStackTrace();
		} catch (Exception e) {
			list = null;
			System.out.println("[error] 알 수 없는 애러 >>" + fileName);
			//e.printStackTrace();
		} finally {
			try {
				if (ois!=null) ois.close();
				if (fis!=null) fis.close();
				
			} catch (IOException e) {
				System.out.println(" [error] 파일 열기 실패");
			}
			
		}
		return list;
	}
}
