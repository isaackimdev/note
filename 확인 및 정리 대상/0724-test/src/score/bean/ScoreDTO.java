package score.bean;

public class ScoreDTO {
	private int score_num; // 학번
	private String score_name; // 이름
	private int score_kor; // 국어
	private int score_eng; // 영어
	private int score_mat; // 수학
	private int score_tot; // 총점
	private double score_avg; // 평균
	
	public ScoreDTO() {}
	
	public int getScore_num() {
		return score_num;
	}
	public void setScore_num(int score_num) {
		this.score_num = score_num;
	}
	public String getScore_name() {
		return score_name;
	}
	public void setScore_name(String score_name) {
		this.score_name = score_name;
	}
	public int getScore_kor() {
		return score_kor;
	}
	public void setScore_kor(int score_kor) {
		this.score_kor = score_kor;
	}
	public int getScore_eng() {
		return score_eng;
	}
	public void setScore_eng(int score_eng) {
		this.score_eng = score_eng;
	}
	public int getScore_mat() {
		return score_mat;
	}
	public void setScore_mat(int score_mat) {
		this.score_mat = score_mat;
	}
	public int getScore_tot() {
		return score_tot;
	}
	public void setScore_tot(int score_tot) {
		this.score_tot = score_tot;
	}
	public double getScore_avg() {
		return score_avg;
	}
	public void setScore_avg(double score_avg) {
		this.score_avg = score_avg;
	}

}
