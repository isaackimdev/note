public class Exam4 {
	public static void main(String[] args) {
		int a = 1;
		float b = 3.14f;
		boolean c = true;
		double d = 123.456;
		long e = 123456789123456789L;
		
		String str1 = String.valueOf(a);
		System.out.println(a+9);
		System.out.println(str1+9);
		
		String str2 = String.valueOf(b);
		System.out.println(b+9);
		System.out.println(str2+9);
		
		String str3 = String.valueOf(c);
		System.out.println(c);
		System.out.println(str3+9);
		
		String str4 = String.valueOf(d);
		System.out.println(d+9);
		System.out.println(str4+9);
		
		String str5 = String.valueOf(e);
		System.out.println(e+9);
		System.out.println(str5+9);
		
		String str6 = ""+e;
		System.out.println(str6);
		
	}
}
