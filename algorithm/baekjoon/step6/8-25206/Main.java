import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Score[] scores = new Score[20];
        StringTokenizer st;
        for(int i = 0; i<20; i++) {
            st = new StringTokenizer(sc.nextLine());
            scores[i].subject = st.nextToken();
            scores[i].gradePoint = Float.parseFloat(st.nextToken());
            scores[i].grade = st.nextToken();
        }

    }
}

class Score {
    String subject;
    float gradePoint; // 학점
    String grade;
}