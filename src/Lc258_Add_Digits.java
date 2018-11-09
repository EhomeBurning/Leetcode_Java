/**
 * Time: O(1)
 * Space: O(1)
 */

public class Lc258_Add_Digits {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}