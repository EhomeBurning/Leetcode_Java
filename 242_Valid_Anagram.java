public class Lc242_Valid_Anagram {
/**
 * Solution 1：直接sort，然后Array.equals(s,t)比较; time:O(nlogn), space: O(n)
 * Solution 2: 建一个a-z的list，然后第一个有的加上去，第二个有的减下去，最后看看这个list空与否
 * Time：O(n)
 * Space: O(1)
 */

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}