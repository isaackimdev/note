import java.util.Scanner;
import java.util.Arrays;

public class Greedy2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        
        String input = sc.nextLine();
        String[] numbers = input.split(" ");
        int[] intNumbers = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++){
            intNumbers[i] = Integer.parseInt(numbers[i]);
        }
        
        Arrays.sort(intNumbers);
        System.out.println(Arrays.toString(intNumbers));
      
        int max1 = intNumbers[n-1];
        int max2 = intNumbers[n-2];
        System.out.println(max1 + " " + max2);

        int res = 0;
        while(true) {
            for(int j = 0; j < k; j++) {
                if ( m == 0) break;
                res += max1;
                m--;
            }
            if (m == 0 ) break;
            res += max2;
            m --;
        }
        
        System.out.println(res);
    }
}
