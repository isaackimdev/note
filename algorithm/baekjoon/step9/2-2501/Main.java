import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int seq = 0;
        // logic
        for(int i = 1; i <= n; i++) {
            if (n % i == 0) { // 약수
                System.out.println(i);
                if (i == k) { 
                    seq += 1;
                    break;
                }
            } 
        }

        bw.write(seq+"\n");
        bw.flush();
        bw.close();
    }
}
