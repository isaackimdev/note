//[?] 주어진 데이터 중에서 가장 큰 값
/**
 * 최댓값 알고리즘(MaxAlgorithm) : (주어진 범위 + 주어진 조건)의 자료들의 가장 큰 값
 */
public class MaxAlgorithm {
    public static void main(String[] args) {
        // 1. init
        int max = Integer.MIN_VALUE;    // 정수 형식의 데이터 중 가장 작은 값으로 초기화

        // 2. input
        int[] numbers = { -2, -5, -3, -7, -1 };
        
        // 3. process
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > max) {
                max = numbers[i]; // MAX : 더 큰 값으로 할당
            }
        }       

         // 4. output
        System.out.println("최댓값 : "+ max);
    }
}
