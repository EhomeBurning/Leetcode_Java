/**
 * Classical Binary Search
 * Description
 * Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.
 *
 * Assumptions
 * There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
 *
 * Examples
 * A = {1, 2, 3, 4, 5}, T = 3, return 2
 * A = {1, 2, 3, 4, 5}, T = 6, return -1
 * A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3
 *
 * Corner Cases
 * What if A is null or A is of zero length? We should return -1 in this case.
 *
 * time = O(logn)
 * space = O(1)
 */

public class ClassicalBinarySearch {
    public int binarySearch(int[] array, int size, int target) {
        // corner case
        if (array == null || array.length == 0)
            return -1;
        int left = 0;
        int right = size - 1;
        while (left <= right) { // 只有一个元素的时候也不能退出，退出状态left = right+1
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                right = mid - 1; // 不能等于middle，会无限循环(a[]={5} ,target = 3) 违反了没有缩小范围的原则
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
