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
}