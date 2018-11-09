public class Lc168_Excel_Sheet_Column_Title {

/**
 * Tag: String-Palidrome, Math
 * Time: O(n)
 * Space: O(n)
 * Note: String本身是不变的，所以要用StringBuilder； 这个题还有个n--要注意
 */

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;  // 很关键
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();

    }
}