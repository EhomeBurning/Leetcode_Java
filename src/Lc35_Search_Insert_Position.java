public class Lc35_Search_Insert_Position {

/**
 * 提问题： accending or decending order; duplicate or not;
 * Tag: Array, Binary Search
 * Time: O(logn)
 * Space: O(1)
 * Note:  判断语句可以简化
 */

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        // if (nums[left] >= target) {
        //     return left;
        // } else if (nums[left] < target && nums[right] >= target) {
        //     return right;
        // } else {
        //     return right + 1;
        // }

        if (target <= nums[left]) {
            return left;
        } else if (target <= nums[right]) {
            return right;
        } else {
            return right + 1;
        }
    }
}