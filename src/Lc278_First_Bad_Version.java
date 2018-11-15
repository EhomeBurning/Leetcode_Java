/**
 * Tag: Binary Search
 * Time: O(logn)
 * why logn: 搜索区间的的变化，n,n/2,n/2^2,...,n/2^k -> n/2^k = 1 -> k = lgn = \theta(logn)
 * Space:O(1)
 * Solution: two nodes left&right;isBadVision(mid) true or false
 * Find the first true
 * Note: 注意起始不是0，而是1
 */


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return 0;
        }
        int left = 1, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isBadVersion(left)) {
            return left;
        }
        if (isBadVersion(right)) {
            return right;
        }
        return 0;
    }
}