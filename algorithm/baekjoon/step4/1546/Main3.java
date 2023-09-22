import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float sum = 0f;
        float[] scores = new float[n];
        for(int i = 0; i < n ; i++) {
            scores[i] = sc.nextFloat();
            sum += scores[i];
        }
        Arrays.sort(scores);
        System.out.println( (sum / (float) n) / scores[n-1] * 100 );

    }
}
