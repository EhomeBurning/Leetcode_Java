package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindAllDuplicatesinanArray
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class FindAllDuplicatesinanArray {
    /**
     * 442. Find All Duplicates in an Array
     * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

     Find all the elements that appear twice in this array.

     Could you do it without extra space and in O(n) runtime?

     Example:
     Input:
     [4,3,2,7,8,2,3,1]

     Output:
     [2,3]

     time : O(n) space : O(1)
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}
