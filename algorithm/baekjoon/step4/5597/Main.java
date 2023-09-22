import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] completedHomeworkStudents = new boolean[30];
        int[] noHomeworkStudents = new int[] {0, 0};
        int j = 0;
        for ( int i = 0; i < completedHomeworkStudents.length; i++) completedHomeworkStudents[i] = false;
        for ( int i = 0; i < 28; i++) completedHomeworkStudents[sc.nextInt() - 1] = true;
        for ( int i = 0; i < completedHomeworkStudents.length; i++) {
            if (completedHomeworkStudents[i] == false) {
                noHomeworkStudents[j] = i+1;
                j++; 
            }
        }
        if (noHomeworkStudents[0] < noHomeworkStudents[1]) {
            System.out.println(noHomeworkStudents[0]);
            System.out.println(noHomeworkStudents[1]);
        } else {
            System.out.println(noHomeworkStudents[1]);
            System.out.println(noHomeworkStudents[0]);
        }
    }
}