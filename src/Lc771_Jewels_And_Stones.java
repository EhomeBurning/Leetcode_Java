import java.util.HashSet;
/**
 * Tag: Hash Tables
 * Time Complexity: O(J.length() + S.length())
 * Space Complexity: O(J.length())
 */
public class Lc771_Jewels_And_Stones {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> Jset = new HashSet();
        for (char j: J.toCharArray())
            Jset.add(j);

        int ans = 0;
        for (char s: S.toCharArray())
            if (Jset.contains(s))
                ans++;
        return ans;
    }
}