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
public class _572_SubtreeofAnotherTree {

    /**
     * time : O(n)
     * space : O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSameTree(s, t)) return true;
        return isSameTree(s.left, t) || isSameTree(s.right, t);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
