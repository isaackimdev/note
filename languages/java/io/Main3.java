package languages.java.io;

import java.io.IOException;

public class Main3 {
    public static void main(String[] args) throws IOException {
        // 문자 입력 받기
        System.out.print("input character : ");
        char c = (char) System.in.read();
        System.in.read();
        System.in.read();

        System.out.println("input character output.. -> "+c);
        System.out.println("ascii convert... -> "+ (int) c);

        System.out.print("input number : ");
        int i = System.in.read() - 48;
        System.out.println("input number output.. -> " +i);
    }   
}
