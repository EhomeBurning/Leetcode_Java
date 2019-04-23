// * Tag: Binary Search -> which half;  
// > Solution:   
// > 1. Step 1. classic binary search, get the mid;  
// > 2. Step 2. num[left], nums[mid]    
// > 2.1 case 1: num[left] < nums[mid]; num[left] <= target < nums[mid], right = mid - 1;    
// > 2.2 case 2: nums[left] > nums[mid]; nums[mid] < target <= nums[right], left = mid + 1;   
// > 2.3 case 3: nums[left] == nums[mid]; left++;  
// * Time: O(logn); worst case O(n);  
// * Space: O(1);   

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            if (nums[mid] == target) {
                return true;
            }
            
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }
}