package languages.java.basic;

public class Basic {
    public static void main(String[] args) {
        /*
         * 1. print
         */
        System.out.println("Hello World");
        /**
         * 서식문자
         * %s : 문자열
         * %Nd : 정수
         * %N.Nf : 실수  - 뒷 N은 소수점 자리 수
         */
        System.out.printf("[%s] [%d] [%2.2f] \n", "Hello Java!", 543, 765.7123);


        /**
         * 2. Variable
         * */
        int num1;
        long num2 = 12345678900000000L;
        double num3 = 3.14d;
        float num4 = 3.14f;
        boolean bool = true; // true, false
        char c = 'A';
        short num5 = 100;
        byte num6 = 100;
        num1 = 100;

        System.out.println("num1="+num1);
        System.out.println("num2="+num2);
        System.out.println("num3="+num3);
        System.out.println("num4="+num4);
        System.out.println("bool="+bool);
        System.out.println("c="+c);
        System.out.println("num5="+num5);
        System.out.println("num6="+num6);

        // 상수
        final double PI = 3.14d;
        System.out.println("final 키워드가 붙은 변수는 상수로 값 변경이 불가 - PI : " + PI);

        // 문자열
        String str = "문자열 입니다.";
        String str1;
        str1 = "반갑습니다.";
        System.out.println("str : " + str);
        System.out.println("str1 : " + str1);
    }
}
