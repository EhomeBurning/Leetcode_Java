public class Lc186_Reverse_Words_in_a_String_II {

/**
 * Tag: String
 * Time: O(n)
 * Space: O(1)
 * Note: 先reverse所有，再reverse所有单词
 */


    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int right = 0, left;
        // Reverse the Words
        while (right < str.length) {
            left = right;
            while (right < str.length && str[right] != ' ') {
                right++;
            }
            reverse(str, left, right - 1);
            right++;
        }
    }

    private void reverse(char[] str, int start, int end) {
        while(start < end) {
            char temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }
}