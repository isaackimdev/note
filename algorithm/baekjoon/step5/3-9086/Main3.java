import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        // 입력과 동시에 출력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String s = sc.next();
            System.out.print(s.charAt(0));
            System.out.println(s.charAt(s.length()-1));
        }
    }
}
