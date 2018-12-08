public class Lc161_One_Edit_Distance {

/**
 * Tag: String
 * Time: O(n)
 * Space: O(1)
 * Solution: 有三种情况，insert，delete，replace，分别去判断
 * Note: String比较用equals， 而其他的不能dereference的比如char需要用==
 */

    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() == t.length()) {
            return isReplace(s, t);
        } else if (s.length() > t.length()) {
            return isDeleteOne(s, t);
        }
        return isDeleteOne(t,s);

    }

    private boolean isReplace(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) { // char CANNOT be DEREFERENCED
                count++;
            }
        }
        return count == 1;
    }

    private boolean isDeleteOne(String s, String t) {
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) { // && 判断必不可少
            if (s.charAt(i) != t.charAt(j)) {
                return s.substring(i + 1).equals(t.substring(j));
            }
        }
        return true;
    }
}