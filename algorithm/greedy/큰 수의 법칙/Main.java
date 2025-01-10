/*
입력
    5 8 3
    2 4 5 4 6

출력    
    46
*/

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        int i;
        for(i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int first = arr[arr.length-1];
        int second = arr[arr.length-2];
        
        int sum = 0;
        for(i = 0; i < m; i++) {
            sum += (i+1)%k != 0 ? first : second;
        }
        System.out.println(sum);

        int firstCount = k * ( m / (k+1));
        int secondCount = ( m / (k+1));
        int mod = m % (k+1);

        sum = (first * firstCount) + (second * secondCount) + (mod * first);
        System.out.println(sum);


        int count = (( m / (k + 1) ) * k);
        count += m % (k+1);
        System.out.println( (first*count) + (m-count)*second );
    }
}