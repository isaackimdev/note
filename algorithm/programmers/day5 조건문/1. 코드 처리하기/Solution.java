class Solution {
    public String solution(String code) {
        String ret = "";
        int mode = 0;
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            
            if (c != '1') {
                if (i % 2 == mode) {
                    ret += c;
                }
                else if (i % 2 == mode) {
                    ret += c;
                }    
            } else {
                mode = mode == 1 ? 0 : 1;
            }
        }
            
        return ret.equals("") ? "EMPTY" : ret;
    }
}