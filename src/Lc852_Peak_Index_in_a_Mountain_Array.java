public class Lc852_Peak_Index_in_a_Mountain_Array {

/**
 * Questions: Duplicate
 * Tag: Binary Search, Array
 * Time: O(logn)
 * Space: O(1)
 * Solution: Compare A[mid] and A[mid + 1];
 * Note: find peak 这种题不需要最后判断low和high
 */

    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length == 0)  {
            return -1;
        }

        int low = 0, high = A.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] <= A[mid + 1]) {
                low = mid;
            } else if (A[mid - 1] >= A[mid]){
                high = mid;
            } else {
                return mid;
            }
        }
        return -1;

    }
}