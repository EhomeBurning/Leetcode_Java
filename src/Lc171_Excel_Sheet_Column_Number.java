public class Lc171_Excel_Sheet_Column_Number {
    /**
     * Tag: String, Math
     * Time: O(n)
     * Space: O(1)
     * Note: res * 26一开始没有想到
     */

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return -1;

        int res = 0;
        for (char c : s.toCharArray()) {
            res = res * 26 + (c - 'A' + 1);
        }
        return res;
    }
}