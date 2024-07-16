import java.util.Scanner;

public class Implement2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int count = 0;

        for(int i = 0; i <= n; i++) {
            for(int m = 0; m < 60; m++) {
                for(int s = 0; s < 60; s++) {
                    String str = ""+i+m+s;
                    if(str.toString().contains("3")) count++;
                }
            }
        }
        
        System.out.println(count);
    }
}
