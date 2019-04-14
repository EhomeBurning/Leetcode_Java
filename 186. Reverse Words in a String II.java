// *Tag*: String -> StringReversal;
// *Solution*:
// Similar to 151. Reverse Words in a String;

class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length <= 1) {
            return;
        }
        reverse(str, 0, str.length - 1);
        
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            // start index
            if (str[i] != ' ' && (i == 0 || str[i - 1] == ' ')) {
                start = i;
            }
            // end index
            if (str[i] != ' ' && (i == str.length - 1 || str[i + 1] == ' ')) {
                int end = i;
                reverse(str, start, end);
            }
        }
        
    }
    
    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }
    }
}
