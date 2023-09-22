# java input/output (io)

Java Console에서 Input/Output에 사용되는 방법 2가지 

1. Scanner를 사용하여 console에서 입력받기
2. BufferdReader 사용하여 console에서 입력받기


__1. Scanner__
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str);
        sc.close();
    }
}
```

__2. BufferedReader__
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(
                new InputStreamReader(System.in)
            );
            
        BufferedWriter bw = 
            new BufferedWriter(
                new OutputStreamWriter(System.out)
            );

        String str = br.readLine();
        bw.write(str);
        bw.flush();
    }
}
```