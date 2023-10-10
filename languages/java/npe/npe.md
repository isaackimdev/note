# NPE - Null Pointer Exception

Null Pointer Exception이 일어난 상황을 공유해보자.

```java
package languages.java.npe;

public class NPE1 {
    public static void main(String[] args) {
        User[] users = new User[2];
        users[0].name = "isaac"; // error
    }    
}

class User {
    String name;
}
```

위 코드를 실행하면 다음과 같은 오류를 발견할 수 있다

```console
Picked up JAVA_TOOL_OPTIONS: -Djava.net.preferIPv4Stack=true
Exception in thread "main" java.lang.NullPointerException
        at languages.java.npe.NPE1.main(NPE1.java:6)
```

`User[] users = new User[2];` 먼저 이 코드만 보았을 때
User 배열 users는 클래스 '배열'을 초기화 한 것이다. 실제로 배열의 원소인 User 클래스는 초기화되진 않은 것이다. `users[0].name = "isaac";` 이 코드는 클래스를 초기화하지 않고 사용했기 때문에 NullPointerException이 발생한다. `users[0]`을 사용하기 위해서는 `users[0] = new User();` 이와 같이 new 키워드와 함께 생성자로 초기화를 해주어야 한다.