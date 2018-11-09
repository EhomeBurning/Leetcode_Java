/**
 * Input: One String, number of Rows
 * Output: Reversed String
 * Tag: String(StringBuilder)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


public class Lc6_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            int loop = 2 * numRows - 2;
            int index = i % loop;
            index = index < numRows ? index : loop - index;
            sb[index].append(s.charAt(i));
        }

        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();

    }
}