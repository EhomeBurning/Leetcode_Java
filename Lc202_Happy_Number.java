import java.util.HashSet;

public class Lc202_Happy_Number {

/**
 * Tag: Hash Table
 * Space: O(n)
 */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int result = getSquare(n);
        while (!set.contains(result)) {
            if (result == 1) {
                return true;
            }
            set.add(result);
            result = getSquare(result);
        }
        return false;
    }

    private int getSquare(int n) {
        int result = 0;
        while (n > 0) {
            int mod = n % 10;
            result += mod * mod;
            n = n / 10;
        }
        return result;
    }
}