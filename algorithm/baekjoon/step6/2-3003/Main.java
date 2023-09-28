import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pieces = new int[] { 1, 1, 2, 2, 2, 8 };
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int i = 0;
        while (st.hasMoreTokens()) {
            System.out.print(pieces[i++] - Integer.parseInt(st.nextToken()) + " ");
        }
    }
}