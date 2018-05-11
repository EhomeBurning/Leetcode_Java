
/**
 * Tag: Math
 * Corner Case: 数值越界
 */
public class Lc7_Reverse_Integer {
    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = 10 * ans + x % 10;
            x /= 10;
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;
        }
        return (int)ans;
    }
}
