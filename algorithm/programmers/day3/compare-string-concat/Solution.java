public class Solution {
    public static void main(String[] args) {
        int a = 89;
        int b = 8;

        int s = Integer.parseInt(a+""+b) >= Integer.parseInt(b+""+a) ? Integer.parseInt(a+""+b) : Integer.parseInt(b+""+a);
        // s = Math.max(3, 4);
        System.out.println(s);
    }
}
