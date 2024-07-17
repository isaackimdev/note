import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        int[] nums = {12, 4, 15, 46, 38, 1, 14};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 5)));
    }
}
