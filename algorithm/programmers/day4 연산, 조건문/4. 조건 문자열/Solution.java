class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        if ( eq.equals("=") ) return ineq.equals("<") ? (n <= m ? 1 : 0) : (n >= m ? 1 : 0);
        else return ineq.equals("<") ? (n < m ? 1 : 0) : (n > m ? 1 : 0);
    }
}