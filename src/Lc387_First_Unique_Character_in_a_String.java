public class Lc387_First_Unique_Character_in_a_String {
/**
 * 还是建一个a-z的list， int[26]
 * Time: O(n)
 * Space: O(n)
 */

/**
 * 易错点笔记： toCharArray记得后面加括号
 */
    public int firstUniqChar(String s) {
        if (s.length() == 0 || s == null) {
            return -1;
        }

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;

    }
}