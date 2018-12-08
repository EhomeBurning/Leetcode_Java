public class Lc125_Valid_Palindrome {

/**
 * Tag: String, Two Pointer
 * Time:
 * Space:
 * Note: 判断是否相等很容易，主要是各种corner case,Character各种方法
 *       两个pointer的char不能存在一个变量里，因为left和right一直在变
 */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < s.length() && !isValid(s.charAt(left))) { // Check left bound
                left++;
            }

            if (left == s.length()) { // like ".;'. ''/'"
                return true;
            }

            while (right >= 0 && !isValid(s.charAt(right))) { // check right bound
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                // 这里很重要，如果不是字母或数字，则要break, 跳出while循环
                break;
            } else {
                left++;
                right--;
            }

        }
        return right <= left;

    }

    private boolean isValid(char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }
}

