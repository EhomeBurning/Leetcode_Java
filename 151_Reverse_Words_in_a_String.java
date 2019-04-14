// *Tag*: String -> StringReversal;
// *Solution*:
// Step1. Reverse the sentence
// Step2. Reverse each word: find the start and end index of the words
// Step3. Clean spaces using two pointers.
// *Tips*:
// 1. Mind leading and trailing spaces of the input String.
// 2. Mind multiple spaces between two words.




class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] strArray = s.toCharArray();
        
        // reverse sentence
        reverse(strArray, 0, strArray.length - 1);
        
        // reverse words
        int start = 0;
        for (int i = 0; i < strArray.length; i++) {
            // find start index
            if (strArray[i] != ' ' &&
                (i == 0 || strArray[i - 1] == ' ')) {
                start = i;
            }
            // find end index
            if (strArray[i] != ' ' &&
                (i == strArray.length - 1 || strArray[i + 1] == ' ')) {
                int end = i;
                reverse(strArray, start, end);
            }
        }
        
        return cleanSpaces(strArray);
    }
    
    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left++] = array[right];
            array[right--] = temp;
        }
    }
    
    private String cleanSpaces(char[] array) {
        int len = array.length;
        int left = 0, right = 0;
        while (right < len) {
            // skip spaces
            while (right < len && array[right] == ' ') {
                right++;
            }
            // move words forward
            while (right < len && array[right] != ' ') {
                array[left++] = array[right++];
            }
            // keep skipping spaces
            while (right < len && array[right] == ' ') {
                right++;
            }
            // Set one space
            if (right < len) {
                array[left++] = ' ';
            }
        }
        return new String(array).substring(0, left);
    }
    
    
}

public class Lc151_Reverse_Words_in_a_String {

/**
 * Tag: String
 * Time:
 * Space:
 * Note: StringBuilder记得要转成String类型才能返回，正则表达式要记一下，空格记得要trim（）
 *       这次写一个StringBuilder的方法，还有一种常规的reverse做法，下一遍的时候写
 */

    public String reverseWords(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }
}
