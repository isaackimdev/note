import java.util.*;
class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 기본 정렬 라이브러리를 이용하여 내림차순 정렬 수행
        Arrays.sort(arr, Collections.reverseOrder());

//        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}