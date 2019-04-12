// *Tag*: String;<br>
// *Solution*: <br>
// isValid(left + 1, right), isValid(left, right - 1); <br>
// *Time*: O(n); Only delete once; <br>
// *Space*: O(1);<br>


class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isValid(s, left + 1, right) || isValid(s,left, right - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }
    // Chech if Palindrome or not;
    private boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
