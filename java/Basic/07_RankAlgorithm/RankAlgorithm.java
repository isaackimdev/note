//[?] 주어진(지정한 범위) 데이터의 순위(등수)를 구하는 로직
/*
 * 순위 알고리즘(RankAlgorithm) : 점수 데이터에 대한 순위 구하기
 */
public class RankAlgorithm {
    public static void main(String[] args) {
        // 1. input - Data structure
        int[] scores = {90, 87, 100, 95, 80 };  // 3, 4, 1, 2, 5
        int[] rankings = { 1, 1, 1, 1, 1 }; // 모두 1로 초기화

        // 2. process RANK
        for (int i = 0; i < scores.length; i++) {
            rankings[i] = 1;    // 1등으로 초기화, 순위 배열을 매 회전마다 1등으로 초기화
            for ( int j = 0; j < scores.length; j++) {
                if (scores[i] < scores[j] ) { // 현재(i)와 나머지들(j) 비교
                    rankings[i]++;
                }
            }
        }

        // 3. output
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i] + "점 : " + rankings[i] + "등");
        }
    }
}
