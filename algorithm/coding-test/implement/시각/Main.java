// 시각
// 입력 : N시 59분 59초 까지 3이 들어간 수 count
// 5 -> 11475
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int h = 0; h <= n; h++) {
            for (int m = 0; m <= 59; m++) {
                for(int s = 0; s <= 59; s++) {
                    if (String.valueOf(h).contains("3") || 
                        String.valueOf(m).contains("3") ||
                        String.valueOf(s).contains("3")
                    ) count++;
                }
            }
        }
        System.out.println(count);
    }
}