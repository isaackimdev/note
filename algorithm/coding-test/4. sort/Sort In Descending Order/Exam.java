import java.util.*;
class Exam {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 3};
        Arrays.sort(arr);
        for(int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}