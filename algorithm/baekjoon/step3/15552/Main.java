// StringTokenizer 사용하는 방법도 존재
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        String[] n;

        for (int i = 0; i<t; i++) {
            n = br.readLine().split(" ");
            bw.write(Integer.parseInt(n[0])+Integer.parseInt(n[1])+"\n");
        }
        bw.flush();
    }
}