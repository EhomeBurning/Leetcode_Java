/**
 * Tag: Array - Sort
 * Time: O(n)
 * Space: O(1)
 */

// *Tag*: Array; Two Pointer; <br>
// *Solution*: <br>
// Two Pointer(same direction); One Pointer "zero" stays at the first zero element; The other Pointer "non -zero" find the first non-zero element; Then swap them; <br>

// *Tips*: <br>
// 1. Name the two pointers as slow and fast can help understand. <br>



class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, slow++, fast);
            }
            fast++;
        }
    }
    
    private void swap(int[] nums, int num1, int num2) {
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }
}
