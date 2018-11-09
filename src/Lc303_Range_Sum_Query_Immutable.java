public class Lc303_Range_Sum_Query_Immutable {
/**
 * Time Complexity: O(1) per query, O(n) pre complexity
 * Space Complexity: O(n)
 */
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}