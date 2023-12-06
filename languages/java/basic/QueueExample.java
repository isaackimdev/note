package languages.java.basic;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(5);
        q.offer(2);
        q.offer(3);
        q.offer(7);
        q.poll();   // 대기열에 있는 것을 하나 꺼낸다.
        q.offer(1);
        q.offer(4);
        q.poll();
        // 먼저 들어온 원소부터 추출
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " "); // 원소를 꺼냄과 동시에 결과를 return 한다.
        }
    }
}
