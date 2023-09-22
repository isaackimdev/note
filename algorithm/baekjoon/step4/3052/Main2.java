import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rs = new int[10];
        for(int i = 0; i<10; i++) rs[i] = sc.nextInt() % 42;
        Arrays.sort(rs);
        int c=1;
        for (int i = 0; i<9; i++) {
            if (rs[i] != rs[i+1]) c++;
        }
        System.out.println(c);
    }
}