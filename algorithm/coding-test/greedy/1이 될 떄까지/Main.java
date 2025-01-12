// N이 1이 될 때까지 
// 1. N에서 1을 뺀다.
// 2. N을 K로 나눈다. (나뉠 때만)
// 위 두가지를 진행하며 N을 1로 만드는 최소 횟수 구하기

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int i = 0;
        while( n != 1) {
            if (n % k == 0) n /= k;
            else n -= 1;
            i++;
        }
        System.out.println(i);
    } 
}
