import java.util.Scanner;

public class Score {
	int num;
	String name;
	int kor, eng, mat, tot, avg;
	
	void set () {			// void set(Score this)
		System.out.println(this);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학번 : ");
		this.num = sc.nextInt();

		System.out.print("이름 : ");
		this.name = sc.next();

		System.out.print("국어 : ");
		this.kor = sc.nextInt();

		System.out.print("영어 : ");
		this.eng = sc.nextInt();
		
		System.out.print("수학 : ");
		this.mat = sc.nextInt();
		this.tot = this.kor + this.eng + this.mat;
		this.avg = this.tot / 3;
	}
	
	void print_title() {	// void print_title(Score this)
		System.out.println(this);
		System.out.println("*** 성적 출력 ***");
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평점");
	}	// [ \t  :  탭키  ]
	void print() {			// void print(Score this)
		System.out.println(this);
		System.out.println(this.num + "\t" + this.name +  "\t"
				+ this.kor+  "\t" + this.eng + "\t"+this.mat +
				 "\t" + this.tot +  "\t" + this.avg);
	}
	
}
