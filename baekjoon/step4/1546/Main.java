import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 0;
        double[] scores = new double[n];
        double sum = 0;
        for(int i=0; i<n; i++) {
            scores[i] = sc.nextInt();
            if(m < scores[i]) m = (int) scores[i];
        }
        for(int i=0; i<n; i++) {
            scores[i] = scores[i] / m * 100;
        }
        for(int i=0; i<n; i++) {
            sum += scores[i];
        }
        System.out.println(sum/n);
    }
}