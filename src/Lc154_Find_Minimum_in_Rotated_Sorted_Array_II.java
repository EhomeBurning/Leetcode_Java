public class Lc154_Find_Minimum_in_Rotated_Sorted_Array_II {

/**
 * Tag: Binary Search, Array;
 * Time: O(logn)
 * Space: O(1)
 * Solution: 153基础上加了个duplicate；比较end和mid关系
 * Note: 找时间重做一遍
 */

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end--;
            }
        }
        if (nums[start] < nums[end]) return nums[start];
        else return nums[end];
    }
}