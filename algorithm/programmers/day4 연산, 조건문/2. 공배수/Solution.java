class Solution {
    public int solution(int num, int n, int m) {
        return num % n == 0 && num % m == 0 ? 1 : 0;
    }
}