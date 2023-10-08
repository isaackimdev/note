import java.util.Scanner;
import java.util.StringTokenizer;

public class STTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringTokenizer st;
        st = new StringTokenizer(s);

        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
    }
}
