import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] angs = new int[3];
        int sum = 0;
        for(int i=0;i<3;i++) {
            angs[i] = Integer.parseInt(br.readLine());
            sum += angs[i];
        }
        String str = "";
        if(sum != 180) {
            str = "Error";
        } else { // 세 각의 합 180
            if (angs[0] == angs[1] && angs[1] == angs[2]) {
                str = "Equilateral";
            } else if(angs[0] != angs[1] && angs[1] != angs[2] && angs[0] != angs[2]) {
                str = "Scalene";
            } else {
                str = "Isosceles";
            } 
        }

        bw.write(str);
        bw.flush();
        bw.close();
    }
}
