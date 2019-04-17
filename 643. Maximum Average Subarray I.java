// > Tag: Array;
// > Solution: Get the sum of k. Keep going forward for fixed window k.
// > Time: O(n);
// > Space: O(1);

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(sum, max);
        }
        return (double)max / k;
    }
}
