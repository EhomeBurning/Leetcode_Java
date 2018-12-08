public class Lc88_Merge_Sorted_Array {

/**
 * Tag: Array - Sort
 * Time: O(m + n)
 * Space: O(1)
 */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1 = m - 1, num2 = n - 1, total = m + n - 1;

        while (num1 >= 0 && num2 >= 0) {
            nums1[total--] = nums1[num1] > nums2[num2] ? nums1[num1--] : nums2[num2--];
        }

        while (num2 >= 0) {
            nums1[total--] = nums2[num2--];
        }
    }
}