import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if (n != 1) {
            for(int i=2; i<=n; i++) {
                if(n%i==0) {
                    n = n / i;
                    bw.write(i+"\n");
                    i = 1;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
