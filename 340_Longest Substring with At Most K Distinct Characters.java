// *Tag*: String, Sliding Window; <br>
// *Solution*: <br>
// Sliding Window -> (i, j); <br>
// Move j and update int[] count; When the numOfDistChar > k, move i, update count if count[s.charAt(i)] == 0 and i++; <br>
// update result;
// *Time*: O(n); <br>
// *Space*: O(1); <br>



class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        // Max Lenght of current sliding window;
        int maxLen = 0;
        int i, j = 0;
        int numOfDistChar = 0;
        int[] count = new int[256];
        
        for (i = 0, j = 0; i <= j && j < s.length(); j++) {
            count[s.charAt(j)]++;
            if (count[s.charAt(j)] == 1) {
                numOfDistChar++;
            }
            
            while (numOfDistChar > k) {
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0) {
                    numOfDistChar--;
                }
                i++;
            }
            
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
