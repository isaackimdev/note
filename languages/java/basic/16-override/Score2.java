
public class Score2 extends Score{
	int mus, com;
	
	Score2(String name, int kor, int eng, int mat, int mus, int com) {
		super(name, kor, eng, mat);
		this.mus = mus;
		this.com = com;
	}
	@Override // 부모 class에 있는 함수를 override 덮어쓰기 함.
	// 부모 class 함수와 같은 이름의 함수가 있어야 함.
	public int calc_tot() {
		tot = super.calc_tot() + mus + com;
		return tot;
	}
	@Override
	public double calc_avg() {
		avg = (double) tot / 5;
		return avg;
	}
	@Override
	public void output_result() {
		System.out.println("이름 : " + name + ", 총점 : "
				+ calc_tot() + ", 평균 : " + calc_avg());
	}
	
}
