package leetcode_301To600;

import java.util.Stack;

/**
 * 本代码来自 Cspiration，由 @Cspiration 提供
 * 题目来源：http://leetcode.com
 * - Cspiration 致力于在 CS 领域内帮助中国人找到工作，让更多海外国人受益
 * - 现有课程：Leetcode Java 版本视频讲解（1-900题）（上）（中）（下）三部
 * - 算法基础知识（上）（下）两部；题型技巧讲解（上）（下）两部
 * - 节省刷题时间，效率提高2-3倍，初学者轻松一天10题，入门者轻松一天20题
 * - 讲师：Edward Shi
 * - 官方网站：https://cspiration.com
 * - 版权所有，转发请注明出处
 */
public class _591_TagValidator {

    /**
     1, The code must be wrapped in a valid closed tag. Otherwise, the code is invalid.
     2, A closed tag (not necessarily valid) has exactly the following format :
        <TAG_NAME>TAG_CONTENT</TAG_NAME>. Among them, <TAG_NAME> is the start tag,
        and </TAG_NAME> is the end tag. The TAG_NAME in start and end tags should be the same.
        A closed tag is valid if and only if the TAG_NAME and TAG_CONTENT are valid.
     3, A valid TAG_NAME only contain upper-case letters, and has length in range [1,9].
        Otherwise, the TAG_NAME is invalid.
     4, A valid TAG_CONTENT may contain other valid closed tags,
        cdata and any characters (see note1) EXCEPT unmatched <,
        unmatched start and end tag, and unmatched or closed tags
        with invalid TAG_NAME. Otherwise, the TAG_CONTENT is invalid.
     5, A start tag is unmatched if no end tag exists with the same TAG_NAME,
        and vice versa. However, you also need to consider the issue of unbalanced when tags are nested.
     6, A < is unmatched if you cannot find a subsequent >.
        And when you find a < or </, all the subsequent characters until the next >
        should be parsed as TAG_NAME (not necessarily valid).
     7, The cdata has the following format : <![CDATA[CDATA_CONTENT]]>.
        The range of CDATA_CONTENT is defined as the characters
        between <![CDATA[ and the first subsequent ]]>.
     8, CDATA_CONTENT may contain any characters.
        The function of cdata is to forbid the validator to parse CDATA_CONTENT,
        so even it has some characters that can be parsed as tag (no matter valid or invalid),
        you should treat it as regular characters.

     time : O(n * m * n)
     space : O(n)

     * @param code
     * @return
     */
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < code.length();) {
            if (i > 0 && stack.isEmpty()) {
                return false;
            }
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0 ) {
                    return false;
                }
                i += 3;
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) {
                    return false;
                }
                for (int k = 0; k < i; k++) {
                    if (!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                if (stack.isEmpty() || !stack.pop().equals(s)) return false;
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) {
                    return false;
                }
                for (int k = 0; k < i; k++) {
                    if (!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                stack.push(s);
            } else {
                i++;
            }
        }
        return stack.isEmpty();
    }
}
