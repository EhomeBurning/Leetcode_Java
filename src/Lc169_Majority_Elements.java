/**
 * Boyer-Moore Voting Algorithm
 * 还有许多其他解法有时间写一下
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Lc169_Majority_Elements {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;

        }
        return candidate;
    }
}