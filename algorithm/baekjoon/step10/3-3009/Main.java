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
        int[][] dots = new int[3][2];
        
        for(int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dots[i][0] = Integer.parseInt(st.nextToken());
            dots[i][1] = Integer.parseInt(st.nextToken());
        }

        int x = dots[0][0] == dots[1][0] ? dots[2][0] : 
            dots[0][0] == dots[2][0] ? dots[1][0] : dots[0][0];
        int y = dots[0][1] == dots[1][1] ? dots[2][1] :
            dots[0][1] == dots[2][1] ? dots[1][1] : dots[0][1];
        
        bw.write(x+" "+y+"\n");
        bw.flush();
        bw.close();
    }
}