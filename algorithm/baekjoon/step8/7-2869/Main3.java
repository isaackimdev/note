import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 시간 초과 오답.
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(
                new InputStreamReader(System.in)
            );
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        int i = 1;
        int s = 0; //start
        for(;s<v;i++) {
            s+=a;
            if(s>=v)break;
            s-=b;
        }
        System.out.println(i);
    }
}