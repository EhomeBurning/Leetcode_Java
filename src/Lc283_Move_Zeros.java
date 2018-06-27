/**
 * Tag: Array - Sort
 * Time: O(n)
 * Space: O(1)
 */

class Lc283_Move_Zeros {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        // count zeros
        int numNonZero = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[numNonZero] = num;
                numNonZero++;
            }
        }

        // Make sure the back is 0
        while (numNonZero < nums.length) {
            nums[numNonZero] = 0;
            numNonZero++;
        }
    }
}