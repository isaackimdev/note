public class Factorial {
    public static void main(String[] args) {
        int result = 0;

        result = factorial(6);
        System.out.println("1="+result);

        result = factorial2(6);
        System.out.println("1="+result);
    }

    // 방법1
    static int factorial(int n) {
        if ( n <= 1 ) return n;
        System.out.print( n + "*" );
        return n * factorial( n - 1 );
    }
    
    // 방법2
    static int factorial2(int n) {
        if ( n > 1 ) {
            System.out.print( n + "*" );
            return n * factorial2( n - 1 );
        }
        return n;
    }
}
