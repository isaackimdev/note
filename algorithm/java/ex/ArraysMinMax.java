package ex;

import java.util.Arrays;
import java.util.OptionalInt;

public class ArraysMinMax {
    public static void main(String[] args) {
        int[] arr = {5, 2, 71, 4, 41, 6};
        OptionalInt opMin = Arrays.stream(arr).min();   // 최솟값
        OptionalInt opMax = Arrays.stream(arr).max();   // 최댓값
        int min = opMin.getAsInt();
        int max = opMax.getAsInt();
        System.out.printf("min : %d, max : %d \n", min, max);
    }
}
