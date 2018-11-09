public class Lc560_SubArray_Sum_equals_to_k {

// Solution: HashMap; Key - prefixSum, Value - # of this sum occurs
// 然后看k - sum在不在之前的hashmap存着
// Time: O(n)
// Space: O(n)

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += sumMap.getOrDefault(sum - k, 0);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    public int subarrySum_TwoPointer(int[] nums, int k) {
        if (k <= 0) return 0;
        int j = 0, sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            while (sum > k) sum -= nums[j++];
            if (sum == k) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 1, 5, 3};
        PositiveSubarraySumEqualsK sol = new PositiveSubarraySumEqualsK();
        System.out.println(sol.subarrySum(nums, 8));
    }
}