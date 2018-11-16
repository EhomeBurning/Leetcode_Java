// time: O(n ^ 2)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1, high = nums.length - 1;
            int target = 0;
            int sum = target - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    // valid 3 sum
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) { // 这里注意还是要加一个限定low < high
                        low++;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }
}

// O(n ^ 2) HashMap
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], map.get(nums[i]) - 1);
            if (map.get(nums[i]) == 0)
                map.remove(nums[i]);
            for (int j = 0; j < i; j ++) {
                int tar = - nums[i] - nums[j];
                if (map.containsKey(tar)) {
                    List<Integer> tmp = Arrays.asList(nums[j], nums[i], tar);
                    Collections.sort(tmp);
                    ans.add(tmp);
                }
            }
        }
        List<List<Integer>> rtn = new ArrayList<>();
        rtn.addAll(ans);
        return rtn;
    }
}