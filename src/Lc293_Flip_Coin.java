import java.util.ArrayList;
/**
 * Tag: String
 * Time: O(n)
 * Space: O(n)
 * Note: 思路比较简单，就是只要遇到++，就将其变为--
 */

import java.util.List;

public class Lc293_Flip_Coin {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
            }
        }
        return list;
    }
}