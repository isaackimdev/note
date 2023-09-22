//[?] : n명의 정수 중에서 80점 이상 95점 이하의 점수의 평균

/*
 * 평균알고리즘(Average Algorithm) : 주어진 범위에 주어진 조건에 해당하는 자료들의 평균
 */
public class AverageAlgorithm {
    public static void main(String[] args) {
        // 1. input : n명의 성적
        int[] sco = { 90, 65, 78, 50, 95 };
        int sum = 0;
        int count = 0;
        
        // 2. process : avg = sum / count
        for (int i = 0; i < sco.length; i++) {
            if(sco[i] >= 80 && sco[i] <= 95) {
                sum += sco[i];
                count++;
            }
        }
        double avg = sum / (double) count;
        // 3. output
        System.out.println("80점 이상 95점 이하인 자료의 평균 : " + avg);

    }
}
