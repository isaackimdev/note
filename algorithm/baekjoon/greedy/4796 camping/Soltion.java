/*
문제 

등산가 김강산은 가족들과 함께 캠핑을 떠났다. 하지만, 캠핑장에는 다음과 같은 경고문이 쓰여 있었다.

캠핑장은 연속하는 20일 중 10일동안만 사용할 수 있습니다.

강산이는 이제 막 28일 휴가를 시작했다. 이번 휴가 기간 동안 강산이는 캠핑장을 며칠동안 사용할 수 있을까?

강산이는 조금 더 일반화해서 문제를 풀려고 한다. 

캠핑장을 연속하는 P일 중, L일동안만 사용할 수 있다. 

강산이는 이제 막 V일짜리 휴가를 시작했다. 강산이가 캠핑장을 최대 며칠동안 사용할 수 있을까? (1 < L < P < V)
*/

/*
입력

입력은 여러 개의 테스트 케이스로 이루어져 있다.

각 테스트 케이스는 한 줄로 이루어져 있고, L, P, V를 순서대로 포함하고 있다.

모든 입력 정수는 int범위이다. 마지막 줄에는 0이 3개 주어진다.
*/

/*
출력

각 테스트 케이스에 대해서, 강산이가 캠핑장을 최대 며칠동안 사용할 수 있는지 예제 출력처럼 출력한다. 
*/

/*
예제 입력

5 8 20
5 8 17
0 0 0
*/

/*
예제 출력

Case 1: 14
Case 2: 11
*/
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while(true) {
            int l = sc.nextInt();
            int p = sc.nextInt();
            int v = sc.nextInt();
            if (l == 0 && l == p && p == v ) break;
            System.out.println("Case "+i++ +": "+ ((l * (v / p)) + Math.min(l, (v % p))));
        }
    }
}