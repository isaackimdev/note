class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        answer = my_string.substring(0, s);
        answer += overwrite_string;
        answer += my_string.substring(answer.length());        
        return answer;

        // String before = my_string.substring(0, s);
        // String after = my_string.substring(s + overwrite_string.length());
        // return before + overwrite_string + after;
    }
}
