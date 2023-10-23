import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            int n = Integer.parseInt(br.readLine());
            int sum = 1;
            String str = n + " = 1";
            if(n == -1) break;
            for (int i = 2; i<n; i++) {
                if (n % i == 0) {
                    sum += i;
                    str += " + " + i;
                }
            }
            if (n != sum) {
                str = n + " is NOT perfect.";   
            }
            bw.write(str +"\n");
            bw.flush();
        }
        bw.close();
    }
    
}