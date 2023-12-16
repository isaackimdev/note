
public class Score {
	String name;
	int kor, eng, mat;
	int tot;
	double avg;
	
	Score(String name, int kor, int eng, int mat){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public int calc_tot() {
		tot = kor + eng + mat;
		return tot;
	}
	public double calc_avg() {
		avg = (double) tot/ 3 ;
		return avg;
	}
	public void output_result() {
		System.out.println("¿Ã∏ß : " + name + ", √—¡° : "
				+ calc_tot() + ", ∆Ú±’ : " + calc_avg());
	}
}
