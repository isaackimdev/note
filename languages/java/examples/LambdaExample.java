package languages.java.examples;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // 1. lambda 아닌 경우 list 출력
        // 1) for 문
        for (int i = 0 ; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println("");

        // 2) 확장 for 문
        for (int a : list) {
            System.out.print(a + " ");
        }
        System.out.println("");

        // 2. lambda 로 list 출력
        list.forEach(integer -> System.out.print(integer+" "));
    }
}
