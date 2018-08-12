public class Lc69_Sqrtx {

/**
 * questions: MAX or MIN VALUE；
 * Tag: Binary Search, Math
 * Time: O(logn)
 * Space: O(1)
 * Note: 只要是关于数字的问题，都要首先问一下有没有超过最大值或最小值； 如果之前用long型，最后记得返回值要用强制类型转换
 相乘的时候超过了MAX也要以long型声明, 或者用相除的方法解决, 相除的时候注意不能为0
 */

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int start = 1, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end <= x / end) {
            return end;
        }
        if (start <= x / start) {
            return start;
        }
        return -1;
    }
}