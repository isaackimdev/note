import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int res = 0; 

        ArrayList list = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
            if(n%i == 0) {
                list.add(i);
            }
        }
        if(list.size() >= k) {
            res = (int)list.get(k-1);
        }

        bw.write(res+"\n");
        bw.flush();
        bw.close();
    }
}
