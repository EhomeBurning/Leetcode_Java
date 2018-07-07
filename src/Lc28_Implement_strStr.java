public class Lc28_Implement_strStr {

/**
 * Tag: String
 * Time: O(n^2)
 * Space: O(1)
 * Note: substring可以传一个参数，即这个index之后的所有substring，如果是两个参数，则最后一个是不包括的
 */

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;

    }
}