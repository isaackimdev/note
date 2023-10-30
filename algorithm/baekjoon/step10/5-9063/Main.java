import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dots = new int[n][2];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dots[i][0] = Integer.parseInt(st.nextToken());
            dots[i][1] = Integer.parseInt(st.nextToken());
        }
        int xmin=dots[0][0], xmax=xmin, ymin=dots[0][1], ymax=ymin;
        for(int i=1;i<n;i++){
            if(xmin>dots[i][0]){xmin=dots[i][0];}
            if(xmax<dots[i][0]){xmax=dots[i][0];}
            if(ymin>dots[i][1]){ymin=dots[i][1];}
            if(ymax<dots[i][1]){ymax=dots[i][1];}
        }
        bw.write((xmax-xmin)*(ymax-ymin)+"\n");
        bw.flush();
        bw.close();
    }
}
