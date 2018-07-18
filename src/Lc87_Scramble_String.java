public class Lc87_Scramble_String {

/**
 * Tag: String, Recursion
 * Time:
 * Space:
 * Solution: 先判断字母组成是否相同，然后再判断substring是否相同
 三维的dp是最优解，但是比较难，所以先写了recursion的
 * Note: substring(0,num) 是0~num - 1的string， 而substring(num) 则是num~len的string， 也就是说第一个index没问题，最后一个要减一
 s1.equals(s2) physically equal, s1 == s2 points to the same object
 */

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return true;
        }
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        // see the letters are the same or not
        int[] letters = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int num : letters) {
            if (num != 0) {
                return false;
            }
        }

        // Recursion
        for (int i = 1; i < len; i++) { // 要从1开始
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(len - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, len - i))) {
                return true;
            }
        }


        return false;

    }
}