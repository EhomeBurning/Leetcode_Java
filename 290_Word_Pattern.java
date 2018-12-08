import java.util.HashMap;
public class Lc290_Word_Pattern {

/**
 * Tag: String, Hash Table
 * Time: O(n)
 * Space: O(n)
 * Note: 与205几乎一模一样，只不过就是把一个带空格的str.split(" ")一下就好
 *       记得要比较下新的String[]和pattern长度是否相同
 */



    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character key = pattern.charAt(i);
            String value = words[i];
            if (map.containsKey(key)){
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