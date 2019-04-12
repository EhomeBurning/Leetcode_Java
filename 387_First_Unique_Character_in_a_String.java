// *Tag*: String;<br>
// *Solution*: <br>
// int[] count = new int[26]; <br>
// count[ch - 'a']++; <br>
// *Time*: O(n); <br>
// *Space*: O(1); <br>
// *Tips*: <br>
// 1. str.length();



class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 0 || s == null) {
            return -1;
        }
        int[] count = new int[26];
        
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (count[cur - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
