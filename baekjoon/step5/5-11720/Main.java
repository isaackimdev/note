import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        String nums = sc.next();
        for(int i = 0; i < n; i++) {
            res += Integer.parseInt(String.valueOf(nums.charAt(i)));
        }
        System.out.println(res);
    }
}