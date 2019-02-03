// Solution: <br>
// Regular Binary Search, assume the first num is the minNum, and set it as a target. Narrow the searching range to two nums. Compare these two with the minNum. 
// <br> <br>
// Time: O(logn) <br>
// Space: O(1) <br>




class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        int minNum = nums[0];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > minNum) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] < minNum) {
            minNum = nums[left];
        }
        if (nums[right] < minNum) {
            minNum = nums[right];
        }
        return minNum;
    }
}