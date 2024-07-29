# stack
선입 후출 : 먼저 들어온 데이터가 나중에 나간다.

```py
stack = [] # list
stack.append()
stack.pop()

print(stack[::-1]) # 최상단 원소부터 출력
print(stack) # 최하단 원소부터 출력
```


```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(5);
        s.push(2);
        s.push(3);
        s.push(7);
        s.pop();
        s.push(1);
        s.push(4);
        s.pop();
        
        // 스택 최상단 원소부터 출력
        while (!s.empty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
}
// 1 3 2 5
```


##### DFS/BFS