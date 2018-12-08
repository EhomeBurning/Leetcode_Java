import java.util.HashMap;

public class Lc205_Isomorphic_Strings {

/**
 * Tag: String, Hash Table
 * Time: O(n)
 * Space: O(n)
 * Note: 这个问题记得要判断一遍key之后，还要再判断一遍value
 */


    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            Character value = t.charAt(i);
            if (map.containsKey(key)) {
                if (map.get(key).equals(value)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (!map.containsValue(value)) {
                    map.put(key, value);
                } else {
                    return false;
                }
            }
        }
        return true;

    }
}