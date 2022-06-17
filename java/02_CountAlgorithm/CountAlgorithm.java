//[?] n개의 정수 중 13의 배수의 개수(건수, 횟수)

/*
 * 개수 알고리즘(Count Algorithm) : 주어진 범위에 주어진 조건에 해당하는 자료들의 개수
 */
public class CountAlgorithm {
    public static void main(String[] args) {
        // 1. input : 1부터 n까지의 데이터
        int[] numbers = {11, 12, 13, 13, 15, 13};
        int count = 0;  // 개수를 저장할 변수는 0으로 초기화

        // 2. process : 개수 알고리즘 영역 : 주어진 범위에 주어진 조건(필터링)
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 13 == 0) {
                // count = count + 1;
                // count += 1;
                count++; // COUNT
            }
        }

        // 3. output
        System.out.println(numbers.length + "개의 정수 중 13의 배수의 개수 : " + count);
    }
}
