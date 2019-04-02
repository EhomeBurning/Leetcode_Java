package leetcode_301To600;

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
public class _423_ReconstructOriginalDigitsfromEnglish {
    /**
     * Given a non-empty string containing an out-of-order English representation of digits 0-9,
     * output the digits in ascending order.

     Note:
     Input contains only lowercase English letters.
     Input is guaranteed to be valid and can be transformed to its original digits.
     That means invalid inputs such as "abc" or "zerone" are not permitted.
     Input length is less than 50,000.
     Example 1:
     Input: "owoztneoer"

     Output: "012"

     zero one two three four five six seven eight nine

     char c = s.charAt(i)

     s(6) + s(7) = 5
     s(6) = 2 x = 2

     time : O(n)
     space : O(n)

     * @param s
     * @return
     */
    public String originalDigits(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') count[0]++;
            if (c == 'w') count[2]++;
            if (c == 'x') count[6]++;
            if (c == 's') count[7]++; //7-6
            if (c == 'g') count[8]++;
            if (c == 'u') count[4]++;
            if (c == 'f') count[5]++; //5-4
            if (c == 'h') count[3]++; //3-8
            if (c == 'i') count[9]++; //9-8-5-6
            if (c == 'o') count[1]++; //1-0-2-4
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];

        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < count[i]; j++) {
                res.append(i);
            }
        }
        return res.toString();
    }
}
