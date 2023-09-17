import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] remains = new int[10];
        // 나머지 값 저장
        for (int i = 0; i < remains.length; i++) {
            remains[i] = sc.nextInt() % 42;
        }
        
        int[] counts = new int[42];
        for (int i = 0; i < 42; i++) {
            counts[i] = -1;
        }

        for (int i = 0; i < remains.length; i++) { // 10;
            counts[remains[i]] ++;
        }

        int count = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != -1) count ++;
        }

        System.out.println(count);
    }
}