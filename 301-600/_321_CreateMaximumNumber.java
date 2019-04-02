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
public class _321_CreateMaximumNumber {
    /**
     * 321. Create Maximum Number
     * Given two arrays of length m and n with digits 0-9 representing two numbers.
     * Create the maximum number of length k <= m + n from digits of the two.
     * The relative order of the digits from the same array must be preserved.
     * Return an array of the k digits. You should try to optimize your time and space complexity.

     Example 1:
     nums1 = [3, 4, 6, 5]        1 2
     nums2 = [9, 1, 2, 5, 8, 3]  4 3
     k = 5
     return [9, 8, 6, 5, 3]

     Example 2:
     nums1 = [6, 7]
     nums2 = [6, 0, 4]
     k = 5
     return [6, 7, 6, 0, 4]

     Example 3:
     nums1 = [3, 9]
     nums2 = [8, 9]
     k = 3
     return [9, 8, 9]

     1：从nums1里取i个元素组成最大数组，从nums2里取k-i个元素组成最大数组。
     2：合并之前结果，得到一个长度为k的最大数组。
     3：对于不同长度分配的情况，比较每次得到的长度为k的最大数组，返回最大的一个。

     Reference : https://segmentfault.com/a/1190000007655603

     time : O((m+n)^3) 不确定
     space : O(k)

     [2,3,1]
     [2,3]

     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] temp = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(temp, 0, res, 0)) {
                res = temp;
            }
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i > k - j && j > 0 && nums[i] > res[j - 1]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }
}
