// > Tag: Binary Search -> Rotated Sorted Array;
// > Time: O(logn);
// > Space: O(1);

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        int begin = nums[0];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > begin) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return Math.min(begin, Math.min(nums[left], nums[right]));
    }
}
