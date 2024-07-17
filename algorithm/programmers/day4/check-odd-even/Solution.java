class Solution {
    public int solution(int n) {
        int res = 0;
        if ( n % 2 == 1 ) { // 홀
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 1) res += i;
            }
        } else { // 짝
            for (int i = 2; i <= n; i++) {
                if (i % 2 == 0) res += (i*i);
            }
        }
        return res;
    }
}