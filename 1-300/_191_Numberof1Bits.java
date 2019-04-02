package leetcode_1To300;

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
public class _191_Numberof1Bits {
    /**
     * 191. Number of 1 Bits
     * Write a function that takes an unsigned integer and returns the number of ’1' bits it has
     * (also known as the Hamming weight).

     For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
     so the function should return 3.

     使用n&(n-1)的方法：n&(n-1)作用：将n的二进制表示中的最低位为1的改为0
                n              n-1            n&(n-1)
     step1:   110101          110100          110100
     step2:   110100          110011          110000
     step3:   110000          101111          100000
     step4:   100000          011111          000000

     time : O(1) / O(logn)
     space : O(1)

     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
