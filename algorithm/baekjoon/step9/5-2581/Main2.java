import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
// 오답
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        ArrayList list = new ArrayList<Integer>();
        int sum = 0;
        int min = -1;
        for(int i=m; i<=n; i++) {
            boolean isPN = true;
            for(int j=2;j<i;j++) {
                if(i % j == 0) {
                    isPN = false;
                    break;
                }
            }
            if(isPN) {
                sum += i;
                list.add(i);
            }
        }
        if (list.size() > 0) {
            min = (int) list.get(0);
            bw.write(sum+"\n");
        }
        bw.write(min+"\n");
        bw.flush();
        bw.close();
    }
}
