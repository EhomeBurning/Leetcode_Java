public class Lc278_First_Bad_Version {

/**
 * Tag: Binary Search
 * Time: O(logn)
 * Space:O(1)
 * Solution: two nodes left&right;isBadVision(mid) true or false
 * Note: 注意起始不是0，而是1
 */


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public int firstBadVersion(int n) {
        if (n <= 0) return -1;

        int left = 1, right = n; // 起始不是0，而是1
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isBadVersion(left)) { // 优化之后的，直接看左边是不是T就可以
            return left;
        }
        return right;

    }
}