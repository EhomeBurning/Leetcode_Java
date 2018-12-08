import java.util.Arrays;
/**
 * Tag: Array
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class Lc561_Array_Partion_I {
    public int arrayPairSum(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num: nums)
            arr[num + lim]++;
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            d = (2 + arr[i + lim] - d) % 2;
        }
        return sum;
    }
}

/**
 * Soltion1
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */
class Alt_Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }
}