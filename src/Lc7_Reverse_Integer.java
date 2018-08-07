
/**
 * Tag: Math
 * Time: O(n)
 * Space: O(1)
 * Note: 判断条件为x不等于0，要注意最初initial的时候是long型，还有不要超出integer范围
 */

public class Lc7_Reverse_Integer {
    public int reverse(int x) {
        long ans = 0;  // 储存更多的数字
        while (x != 0) {  // 不是大于0， 是不等于
            ans = 10 * ans + x % 10;
            x /= 10;
        }
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)ans;
    }
}


