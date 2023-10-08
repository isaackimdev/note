import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        double t = 0;
        double scoSum = 0;
        double GPA = 0;
        for(int i = 0; i<20; i++) {
            st = new StringTokenizer(sc.nextLine());
            String sbj = st.nextToken();
            double sco = Double.parseDouble(st.nextToken());
            String g = st.nextToken();
            if(g.equals("P")) continue;
            if(g.equals("A+")) t += (sco * 4.5);
            else if(g.equals("A0")) t += (sco * 4.0);
            else if(g.equals("B+")) t += (sco * 3.5);
            else if(g.equals("B0")) t += (sco * 3.0);
            else if(g.equals("C+")) t += (sco * 2.5);
            else if(g.equals("C0")) t += (sco * 2.0);
            else if(g.equals("D+")) t += (sco * 1.5);
            else if(g.equals("D0")) t += (sco * 1.0);
            else if(g.equals("F")) t += (sco * 0.0);
            scoSum += sco;
        }
        GPA = Double.isNaN(t / scoSum) ? 0 : t/scoSum;
        System.out.printf("%.6f\n", GPA);
        sc.close();
    }
}