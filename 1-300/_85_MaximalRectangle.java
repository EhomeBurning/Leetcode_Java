package leetcode_1To300;

import java.util.Arrays;
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
public class _85_MaximalRectangle {
    /**
     * 85. Maximal Rectangle
     * Given a 2D binary matrix filled with 0's and 1's,
     * find the largest rectangle containing only 1's and return its area.

     For example, given the following matrix:

     1 0 1 0 0
     1 0 1 1 1
     1 1 1 1 1
     1 0 0 1 0
     Return 6.


     left[] ：从左到右，出现连续‘1’的string的第一个座标
     right[] ：从右到左, 出现连续‘1’的string的最后一个座标，
     height[] ： 从上到下的高度。
     res ： (right[j] - left[j]) * heights[j]
     
     height:
     1 0 1 0 0
     2 0 2 1 1
     3 1 3 2 2
     4 0 0 3 0

     left:
     0 0 2 0 0
     0 0 2 2 2
     0 0 2 2 2
     0 0 0 3 0

     right:
     1 5 3 5 5
     1 5 3 5 5
     1 5 3 5 5
     1 5 5 4 5

     time : O(m * n)
     space : O(n)

     * @param matrix
     * @return
     */

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (matrix == null || m == 0) return 0;
        int n = matrix[0].length;
        int res = 0;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(curLeft, left[j]);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(curRight, right[j]);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for (int j = 0; j < n; j++) {
                res = Math.max(res, (right[j] - left[j]) * height[j]);
            }
        }
        return res;
    }

    /**
     time : O(m * n)
     space : O(n)

     * @param matrix
     * @return
     */

    public int maximalRectangle2(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix[0].length;
        int[] height = new int[n + 1];
        height[n] = 0;
        int res = 0;

        for (int row = 0; row < matrix.length; row++) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n + 1; i++) {
                if (i < n) {
                    if (matrix[row][i] == '1') {
                        height[i]++;
                    } else height[i] = 0;
                }
                if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                        int cur = height[stack.pop()] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                        res = Math.max(res, cur);
                    }
                    stack.push(i);
                }
            }
        }
        return res;
    }
}
