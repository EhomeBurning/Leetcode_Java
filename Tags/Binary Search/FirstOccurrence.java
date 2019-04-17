/**
 * First Occurrence
 * Description
 * Given a target integer T and an integer array A sorted in ascending order, find the index of the first occurrence of T in A or return -1 if there is no such index.
 *
 * Assumptions
 * There can be duplicate elements in the array.
 *
 * Examples
 * A = {1, 2, 3}, T = 2, return 1
 * A = {1, 2, 3}, T = 4, return -1
 * A = {1, 2, 2, 2, 3}, T = 2, return 1
 *
 * Corner Cases
 * What if A is null or A of zero length? We should return -1 in this case.
 *
 * time = O(logn)
 * space = O(1)
 */

public class FirstOccurrence {
    public int firstOcurr(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;// mid-1 wrong 可能当前找到的就只有一个target元素
            } else if (target < array[mid]) {
                right = mid;// right=mid–1;right已经不是目标元素了，所以移位也不要紧
            } else {
                left = mid;// left = mid + 1; right
            }
        }
        
        if (array[left] == target) {
            return left; // check array[left] against target
        }
        if (array[right] == target) {
            return right;// check array[right] against target
        }
        return -1;// 如果左右都不相等，说明该元素不存在。上一题不需要，因为只要找离target最近的element即可。
    }
}
