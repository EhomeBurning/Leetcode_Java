
public class Lc268_Missing_Number {

/**
 * Tag: Bit Manipulation
 * Time: O(n)
 * Space: O(n)
 * 我先用HashSet写了一个solution， 学完bit再重新写一个
 */

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int len = nums.length + 1;
        for (int i = 0; i < len; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;

    }
}