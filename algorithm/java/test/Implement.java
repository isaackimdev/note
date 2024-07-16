import java.util.Scanner;

public class Implement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[n][n];

        String cmdLine = sc.nextLine();
        String[] cmds = cmdLine.split(" ");

        int i = 0, j = 0;
        for(int cIndex = 0; cIndex < cmds.length; cIndex++) {
            switch (cmds[cIndex] ) {
                case "R" : 
                    j++;
                    if (j >= n) j--;
                    break;
                case "L" :
                    j--;
                    if (j < 0) j++;
                    break;
                case "U" : 
                    i--;
                    if (i < 0) i++;
                    break;
                case "D" :
                    i++;
                    if (i >= n) i--;
                    break;
            }
        }

        System.out.println((i+1)+" "+(j+1));
    }
}