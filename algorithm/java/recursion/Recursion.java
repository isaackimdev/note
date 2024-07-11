public class Recursion {
    public static void main(String[] args) {
        int result = recursion(3);
        System.out.println("최종값 : " + result);
    }

    static int recursion(int n) {
        if ( n == 0 ) return n;
        System.out.println("n의 값 : " + n);
        return recursion(n-1);
    }
}
