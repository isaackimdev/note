class Solution {
    public int solution(String s) {
        int sum = 0;
        for(char c : s.toCharArray()) sum += Integer.parseInt(String.valueOf(c));
        return sum ;
    }
}
