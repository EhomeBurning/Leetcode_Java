/**
 * Tag: String
 * Time: O(n)
 * Space: O(1)
 * Note: indexOf(String, int) -> 第一个出现完整String的index的值，int可有可无，指int后第一个出现的index值
 *       flow.indexOf(flower) = -1, 因为没有完整的flower
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(ans) != 0) {
                ans = ans.substring(0, ans.length() - 1);
            }
        }
        return ans;
    }
}
