public class Lc58_Length_of_Last_Word {

/**
 * Tag: String
 * Time: O(1)
 * Space: O(1)
 * Note: String.trim() 将前后的空格全部去掉，lastIndexOf() 从后往前数第一个出现的index的数值
 */

    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}