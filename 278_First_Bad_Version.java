
//
// * Tag: Binary Search -> left + 1 < right;
// * Solution: First true; if (nums[mid] == target) right = mid;
// * Time: O(logn);
// * Space: O(1);
// * Note: 注意起始不是0，而是1
// * why logn: 搜索区间的的变化，n,n/2,n/2^2,...,n/2^k -> n/2^k = 1 -> k = lgn = \theta(logn)

/* The isBadVersion API is defined in the parent class VersionControl.
 boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }
        
        int left = 1, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid) == true) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isBadVersion(left) == true) {
            return left;
        }
        if (isBadVersion(right) == true) {
            return right;
        }
        return -1;
    }
}
