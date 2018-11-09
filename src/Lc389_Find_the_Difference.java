public class Lc389_Find_the_Difference {

/**
 * Time: O(n)
 * Space: O(1)
 */
    public char findTheDifference(String s, String t) {
        int charToNum = t.charAt(s.length());

        for(int i = 0; i < s.length(); i++) {
            charToNum += (int)t.charAt(i);
            charToNum -= (int)s.charAt(i);
        }
        return (char)charToNum;
    }
}