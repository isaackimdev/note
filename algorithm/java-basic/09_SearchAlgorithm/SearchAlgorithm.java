/*
 * 검색 알고리즘(Search Algorith)
 * 
 * 순차 검색 : 전체 데이터를 처음부터 끝까지 순서대로 검색합니다. Sequential Search
 * 이진 검색 : 정렬되어 있는 데이터를 절반 나눠서 검색합니다. Binary Search
 * 
 * 이진 검색(Binary Search) 알고리즘
 * 이진 검색 알고리즘은 주어진 데이터가 오름차순으로 정렬되어 있다고 가정합니다.
 * 만약 실제 데이터가 정렬되어 있지 않다면, 앞서 배운 정렬 알고리즘 등을 이용하여 정렬한 다음에
 * 이진 검색 알고리즘 로직을 적용해야 합니다. 이진 검색 알고리즘은 영어로 Divide and Conquer(나누기 및 정복)
 * 알고리즘으로 표현하는데 그 의미 그대로 데이터를 절반으로 나눠서 검색하여 순차 검색보다 효율을 높입니다.
 * 중간 인덱스를 찾는 것이 핵심 로직입니다.
 */

 //[?] 정렬되어 있는 데이터를 이진 검색(이분 탐색)을 사용하여 반씩 나눠서 검색
 /*
  * 검색 알고리즘( Search Algorithm ) : 주어진 데이터에서 특정 데이터 찾기
  */
public class SearchAlgorithm {
    public static void main(String[] args) {
        // 1. input
        int[] data = { 1, 3, 5, 7, 9 }; // 오름차순으로 정렬되었다고 가정
        int N = data.length;    // 의사코드
        int search = 3; // 검색할 데이터
        boolean flag = false; // 찾았으면 true 그렇지 않으면 false
        int index = -1; // 찾은 위치(index)

        // 2. process : 이진 검색(Binary Search) : 개념적으로 (Full Scan -> Index Scan)
        int low = 0;        // min :  낮은 인덱스
        int high = N - 1;   // max : 높은 인덱스
        while (low <= high) {
            int mid = (low + high) / 2; // 중간 인덱스 구하기
            if (data[mid] == search) {
                flag = true; index = mid; break;
            }
            if (data[mid] < search) {
                low = mid + 1;  // 찾을 데이터가 크면 오른쪽 영역으로 이동
            } else 
                high = mid - 1; // 찾을 데이터가 적으면 왼쪽 영역으로 이동
        }

        // 3. output
        if(flag) {
            System.out.println(search + "를 "+ index + "위치에서 찾았습니다.");
        } else {
            System.out.println("찾지 못했습니다.");
        }
    }
}
