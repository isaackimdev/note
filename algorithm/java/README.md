# Algorithm - java

## 재귀(Recursion) 함수
컴퓨터 과학에 있어 재귀는 자신을 정의할 때 자기 자신을 재참조하는 방법을 뜻하며, 이를 프로그래밍에 적용한 재귀 호출(recursive call)의 형태로 많이 사용된다. 또 사진이나 그림 등에서 재귀의 형태를 사용하는 경우도 있다.

example
```c
 unsigned int factorial(unsigned int n)
 {
     if (n <= 1)
         return 1;
     else
         return n * factorial(n-1);
 }
```

재귀가 사용되는 대표적인 알고리즘 예시로 factorial, fibonacci 등이 있다.