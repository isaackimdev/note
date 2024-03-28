2024.03.28

java에서 record라는 키워드를 뒤늦게 확인했다.

Vo, DTO의 생성자, getter, setter 없이 한 줄로 다 구성할 수 있다.

lombok을 어느정도 대체할 수 있을 것으로 보인다.

```java
// Greeting.java
public record Greeting(long id, String content) { }
```
