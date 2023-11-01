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
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            if (a == 0 && b == 0 && c == 0) break;

            String res = "";

            int max = a;
            int ex = b + c;

            if (max < b) {
                max = b;
                ex = a + c;
            }
            if (max < c) {
                max = c;
                ex = a + b;
            }
            
            if (max >= ex ) res="Invalid\n";
            else if (a==b&&b==c) res="Equilateral\n";
            else if (a==b||a==c||b==c) res="Isosceles\n";
            else res="Scalene\n";
            bw.write(res);
        }
        bw.flush();
        bw.close();
    }
}
