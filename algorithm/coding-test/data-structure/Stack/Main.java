import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        
        // 5 - 2 - 4 - 7 - 1 - 삭제 - 8 - 2 - 삭제
        s.push(5);
        s.push(2);
        s.push(4);
        s.push(7);
        s.push(1);
        s.pop();
        s.push(8);
        s.push(2);
        s.pop();
        
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }    
}
