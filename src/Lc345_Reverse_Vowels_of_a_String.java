public class Lc345_Reverse_Vowels_of_a_String {

/**
 * Tag: String
 * Time：O(n)
 * Space: O(n)
 * 小规律：基本要reverse string的都要将其变成CharArray
 * Note：两个pointer，只要不是元音的就都向中间移动，两个都是元音时就交换
 *       valueOf 将charArray转成String，swap 注意要不要++或者--, swap 改变array但是不改变数值
 */


    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] words = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && vowels.indexOf(words[start]) == -1) {
                start++;
            }
            while (start < end && vowels.indexOf(words[end]) == -1) {
                end--;
            }
            swap(words, start, end);
            start++;
            end--;
        }
        return String.valueOf(words);
    }

    private void swap(char[] words, int start, int end) {
        char temp = words[start];
        words[start] = words[end];
        words[end] = temp;
    }
}