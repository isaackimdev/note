import java.util.Arrays;

public class Greedy {
    public static void main(String[] args) {
        int n = 1260;
        int count = 0;

        int[] coin_type = {500, 100, 50, 10};

        for ( int coin : coin_type ) {
            count += n / coin;
            n = n % coin;
        }
        System.out.printf("n : %d, count : %d", n, count);
    }
}
