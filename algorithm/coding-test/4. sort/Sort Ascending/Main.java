import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> list = new ArrayList<Student>();

        for(int i = 0; i < n; i++) {
            list.add(new Student(sc.next(), sc.nextInt()));
        }

        list.sort(Comparator.comparingInt(Student::getScore)); // 오름차순

        // 내림차순
        // list.sort(Comparator.comparingInt(Student::getScore).reversed());

        // 성적이 낮은 순서로 학생 출력하기
        for(Student s : list) {
            System.out.print(s.getName()+" ");
        }
    }
}

class Student {
    private String name;
    private int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
}