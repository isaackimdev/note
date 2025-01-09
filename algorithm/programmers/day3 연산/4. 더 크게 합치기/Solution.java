class Solution {
    public int solution(int a, int b) {        
        String sa = String.valueOf(a);
        String sb = String.valueOf(b);
        String res = Integer.valueOf((sa+sb)) >= Integer.valueOf((sb+sa)) ? sa+sb : sb+sa;
        return Integer.valueOf(res);
    }
}

/*
class Solution {
    public int solution(int a, int b) {
        return Math.max(Integer.parseInt(a + "" + b), Integer.parseInt(b + "" + a));
    }
}
*/
