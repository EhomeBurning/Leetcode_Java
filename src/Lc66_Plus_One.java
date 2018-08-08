/**
 * Tag: Array, Math
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Lc66_Plus_One {

/**
 * Tag: Array. Math
 * Time: O(n)
 * Space: O(n)
 * Solution: 从后往前遍历所有数字，最后一位如果小于9的就加上1，然后break；等于9的就变为0，继续遍历；最后看看第一位是不是0；
 * Note: 记得要break；记得要判断最前面的是不是0；
 */


    public int[] plusOne(int[] digits) {
        if (digits.length == 0 || digits == null) {
            return digits;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;  // 这个break很关键
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}