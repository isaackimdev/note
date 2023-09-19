import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, sum = 0;
        float m = 0f;
        n = sc.nextInt();
        float[] scores = new float[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextFloat();
            sum += scores[i];
            if (m < scores[i]) m = (int) scores[i];
        }
        System.out.println ( ( (sum / (float) n ) / m ) * 100);
    }
}