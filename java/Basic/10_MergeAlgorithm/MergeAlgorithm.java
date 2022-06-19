//[?] 2개의 정수 배열 합치기, 단 2개의 배열은 오름차순으로 정렬되어 있다고 가정
/**
 * 병합 알고리즘(Merge Algorithm) : 오름차순으로 정렬되어 있는 정수 배열을 하나로 병합.
 * 병합 정렬
 * 
 * first 1, 3, 5  : M = 3
 * second 2, 4  : N = 2
 * merger 1, 2, 3, 4, 5
 * i, j, k
 * marge[k++] <- first[i++] < second[j++] 이 중 작은 값을 merge 배열에 넣는다.
 * 
 */
public class MergeAlgorithm {

    public static void main(String[] args) {
        // 1. input
        int[] first = {1, 3, 5};
        int[] second = {2, 4};
        int M = first.length; int N = second.length; // M:N 관행
        int[] merge = new int[M+N]; // 병합된 배열
        int i = 0; int j = 0; int k = 0;    // i, j, k 관행
        
        // 2. process : MERGE
        while ( i < M && j < N) {// 둘 중 하나라도 배열의 끝에 도달할 때까지
            if ( first[i] < second[j])  // 작은 값을 merge 배열에 저장
                merge[k++] = first[i++];
            else merge[k++] = second[j++];
        }
        while (i < M) { // 첫 번째 배열이 끝까지 도달할 때까지
            merge[k++] = first[i++];
        }
        while (j < N) { // 두 번째 배열이 끝까지 도달할 때까지
            merge[k++] = second[j++];
        }
        // 3. output
        for(int item : merge) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}