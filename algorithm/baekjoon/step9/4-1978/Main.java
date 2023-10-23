import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int cnt = 0;
        for (int i=0;i<n;i++){
            boolean isPN = true;
            int c = Integer.parseInt(st.nextToken());
            for(int j=2;j<c;j++) {
                if(c%j==0){
                    isPN = false;
                    break;
                }
            }
            if(c==1)isPN = false;
            if(isPN) cnt++;
        }
        bw.write(cnt +"\n");
        bw.flush();
        bw.close();
    }
}