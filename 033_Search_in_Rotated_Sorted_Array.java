public class Lc33_Search_in_Rotated_Sorted_Array {

/**
 * questions: order; duplicate;
 * Tag: Binary Search, array;
 * Time: O(logn);
 * Space:O(1);
 * Solution: Compared this question to the normal binary search probs, the diff is this one should consider the
 * Note: 内部判断可以简化
 */

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[left]) {
                if (target < nums[left]) {
                    left = mid;
                } else if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (target < nums[mid]) {
                    right = mid;
                } else if (nums[mid] < target && target <= nums[right]) { // 这里是right，而不是left
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }

        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;


    }
}

// * Tag: Binary Search -> which half;
// > Solution: 
// > 1. Step 1. classic binary search, get the mid;
// > 2. Step 2. num[left] and nums[mid]
//     > case 1: num[left] <= nums[mid]; num[left] <= target < nums[mid], right = mid - 1;
//     > case 2: nums[mid] <= nums[right]; nums[mid] < target <= nums[right], left = mid + 1;
// * Time: O(logn);
// * Space: O(1);


class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            if (nums[mid] <= nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}