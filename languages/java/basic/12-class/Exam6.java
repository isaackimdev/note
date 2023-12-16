
public class Exam6 {
	public static void main(String[] args) {
		Score N = new Score();
		Score M = new Score();
		System.out.println("N = "+N+"\nM = "+ M);		
				
		N.set();		// N.set(N);
		M.set();		// M.set(M);
		N.print_title();// N.print_title(N)
//		M.print_title();// M.print_title(M);	
		N.print();		// N.print(N);
		M.print();		// M.print(M);
	}
}
