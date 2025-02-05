import java.util.*;
import java.util.stream.*;
class Main {
    public static void main(String[] args) {
        // 두 배열의 원소 교체
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int [] a = new int[n];
        Integer [] b = new Integer[n];

        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
        for(int i = 0; i < n; i++) b[i] = sc.nextInt();

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        for(int i = 0; i < k; i++) {
            if (a[i] < b[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            else break;
        }

        int sum = Arrays.stream(a).sum();
        System.out.println(sum);

    }
}