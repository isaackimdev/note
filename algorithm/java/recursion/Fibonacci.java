public class Fibonacci {
    public static void main(String[] args) {
        int rs = fibo(6);
        System.out.println(rs);
    }
    
    static int fibo(int n) {
        if ( n <= 2 ) {
            return 1;
        }
        return fibo( n - 2 ) + fibo( n - 1 );
    }
}
