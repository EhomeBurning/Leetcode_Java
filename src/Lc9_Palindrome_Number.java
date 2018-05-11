/**
 * Input: A number
 * Output: Is it Palindrome or not?
 * Tag: Math
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Lc9_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0 || x > 0 && x % 10 == 0) {
            return false;
        }

        int origin = x;
        int rev = 0;
        while (x > 0) {
            int mod = x % 10;
            rev = 10 * rev + mod;
            x /= 10;
        }

        return origin == rev;

    }
}