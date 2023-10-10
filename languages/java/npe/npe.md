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

이유는 users 배열의 클래스를 초기화하지 않고 사용했기 때문에 NullPointerException이 발생한다.