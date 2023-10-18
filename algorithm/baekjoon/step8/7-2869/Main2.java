import java.util.Scanner;
// 결과는 맞지만 시간 초과로 인하여 정답은 아님
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); //+
        int b = sc.nextInt(); //-
        int v = sc.nextInt(); 
        int i = 1;
        int s = 0; //start
        for(;s<v;i++) {
            s+=a;
            if(s>=v)break;
            s-=b;
        }
        System.out.println(i);
    }
}