public class Exam1 {
	public static void main(String[] args) {
		short s = 100;
		int i = s;
		long l = i;
		float f = l;
		double d = f;
		char ch = 'A';
		int num = ch;
		
		System.out.println("s="+s);
		System.out.println("i="+i);
		System.out.println("l="+l);
		System.out.println("f="+f);
		System.out.println("d="+d);
		System.out.println("num="+num);
		System.out.println("-----------------");
		
		l =100000L;
		i = (int)l;  // -20억~+20억
		s = (short)i;  // -3만~+3만
		System.out.println("s="+s);
		System.out.println("i="+i);
		System.out.println("l="+l);
		System.out.println("-----------------");
		byte bb = 127;
		System.out.println("bb="+bb);
		bb++;
		System.out.println("bb="+bb);
		
		// 정수를 문자형으로 변환 정수는 4byte 문자는 2byte
		num = 65;				// 'A'
		ch = (char)(num + 2);	// 'C'
		System.out.println("ch=" + ch);
		
	}
}
