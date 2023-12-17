package score;

import java.io.Serializable;

// Java beans Class
// 클래스명VO, 클래스명DTO
// VO(Value Object) , DTO(Data Transfer Object)
public class ScoreVO implements Serializable {
	private String hak; 		// 학번
	private String name; 		// 이름
	private int kor;			// 국어
	private int eng;			// 영어
	private int mat;			// 수학
	private int tot;			// 총점
	private double avg;			// 평균
	// 모든 변수를 출력해주는 역할 : toString() 함수
	// 모든 변수값 출력용
	public String toString () {
		if(hak == null || name == null) {
			return null;
		}
		String str = String.format("%5s %6s %3d %3d %3d %3d %3.1f",	// printf 랑 같음.
				hak, name, kor, eng, mat, tot, avg);
		return str;
	}
	
	public String getHak() {
		return hak;
	}
	public void setHak(String hak) {
		this.hak = hak;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
}
