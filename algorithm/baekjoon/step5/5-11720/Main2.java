import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String numString = br.readLine();
        int sum = 0;
        for(int i = 0; i<n; i++) sum += Integer.parseInt(Character.toString(numString.charAt(i)));
        System.out.println(sum);
    }
}