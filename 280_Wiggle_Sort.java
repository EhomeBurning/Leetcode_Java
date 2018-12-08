

/**
 * Solution 1
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)


 class Solution {
 public void wiggleSort(int[] nums) {
 Arrays.sort(nums);
 for (int i = 1; i < nums.length - 1; i += 2) {
 swap(nums, i, i + 1);
 }
 }

 private void swap(int[] nums, int i, int j) {
 int temp = nums[i];
 nums[i] = nums[j];
 nums[j] = temp;
 }
 }

 */

/**
 * Solution 2
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Lc280_Wiggle_Sort {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}



