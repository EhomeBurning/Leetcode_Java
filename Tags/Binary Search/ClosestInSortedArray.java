/**
 * Closest In Sorted Array
 * Description
 * Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.
 *
 * Assumptions
 * There can be duplicate elements in the array, and we can return any of the indices with same value.
 *
 * Examples
 * A = {1, 2, 3}, T = 2, return 1
 * A = {1, 4, 6}, T = 3, return 1
 * A = {1, 4, 6}, T = 5, return 1 or 2
 * A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
 *
 * Corner Cases
 * What if A is null or A is of zero length? We should return -1 in this case.
 *
 * time = O(logn)
 * space = O(1)
 */

public class ClosestInSortedArray {
    public int closest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            // avoid infinite loop 提前一步停下来
            // Think about the case when left == right – 1
            // then mid = left, it will be possible picking[mid, right] for the next round,
            // and it will go into an infinite loop in that case.
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target < mid) {
                right = mid;// Wrong right = mid - 1;可能会忽略掉某些元素。{1,4,5} target = 3, 第二步会直接L=M=R，跳过了正确答案4
            } else {
                left = mid;
            }
        }
        // post-processing
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
            return left;
        } else {
            return right;
        }
    }
}
