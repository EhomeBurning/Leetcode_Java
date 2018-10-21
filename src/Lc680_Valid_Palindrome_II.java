// time: O(n)
// space: O(1)
// solution: not palidrome, then check (i+1, j) and (i, j-1)

class Solution {
    public boolean validPalindrome(String s) {
          for (int i = 0; i < s.length() / 2; i++) {
              if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                  int j = s.length() - 1 - i;
                  return isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1);
              }
          }
          return true;
    }
    
    private boolean isPalindromeRange(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
}