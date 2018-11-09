import java.util.HashSet;

public class Lc217_Contains_Duplicate {

/**
 * Tag: Hash Table
 * Solution 1: Sort; Solution 2: HashSet
 * Time: O(n)
 * Space: O(n)
 */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;


    }
}