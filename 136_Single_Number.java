import java.util.HashSet;

public class Lc136_Single_Number {
    // 下次用XOR做一次
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                set.remove(nums[i]);
            } else{
                set.add(nums[i]);
            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){
                res = nums[i];
            }
        }
        return res;
    }

}
