/**
 * Tag: Array
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


public class Lc283_Move_Zeros {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int numNonZero = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[numNonZero] = num;
                numNonZero++;
            }
        }

        while (numNonZero < nums.length) {
            nums[numNonZero] = 0;
            numNonZero++;
        }
    }
}