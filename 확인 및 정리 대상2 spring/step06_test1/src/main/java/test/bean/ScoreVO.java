package test.bean;

public class ScoreVO {
	private String studNo = null;
	private String name = null;
	private int kor = 0;
	private int eng = 0;
	private int mat = 0;
	private int tot = 0;
	private double avg = 0;
	private String logtime = null;
	
	public ScoreVO() {
		super();
	}
	@Override
	public String toString() {
		return "ScoreVO [studNo=" + studNo + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat
				+ ", tot=" + tot + ", avg=" + avg + ", logtime=" + logtime + "]";
	}
	public ScoreVO(String studNo, String name, int kor, int eng, int mat, int tot, double avg, String logtime) {
		super();
		this.studNo = studNo;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.avg = avg;
		this.logtime = logtime;
	}
	public String getStudNo() {
		return studNo;
	}
	public void setStudNo(String studNo) {
		this.studNo = studNo;
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
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	
	
	
}
