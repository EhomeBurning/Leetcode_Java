public class Lc383_Ransom_Note {

/**
 * 类似于242题，都是把a-z放到一个list里，然后对两个input string进行操作
 * Time: O(n)
 * Space: O(1)
 */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] count = new int[26];
        for (char mag : magazine.toCharArray()) {
            count[mag - 'a']++;
        }
        for (char ransom : ransomNote.toCharArray()) {
            if (--count[ransom - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}