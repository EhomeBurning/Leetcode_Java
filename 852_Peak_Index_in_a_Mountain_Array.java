// Solution: Basic Binary Search;
// Time: O(nlogn);
// Space: O(1);


class Solution {
    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[left] > A[right]) {
            return left;
        }
        if (A[right] > A[left]) {
            return right;
        }
        
        return -1;
    }
}
