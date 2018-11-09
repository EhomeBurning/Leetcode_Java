public class Lc153_Find_Minimum_in_Rotated_Sorted_Array {
/**
 * Questions: No duplicate; order;
 * Tag: Binary Search, Array
 * Time: O(logn)
 * Space: O(1)
 * Solution: 跟rotate array找target一个原理，把第一个作为target; 需要两个指针， start + 1 < end;
 * Note:
 */

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int target = nums[0];
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] < target) {
            return nums[end];
        }
        if (nums[start] < target) {
            return nums[start];
        }
        return target;

    }
}