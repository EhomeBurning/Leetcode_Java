// * Tag: Binary Search;
// > Solution:
// > 1. Step 1: get the midVal(half of minVal and maxVal);
// > 2. Step 2: count how many numbers bigger than midVal;
// > 3. Step 3: change min or max depends on relationship between k and midVal;
// * Time: O(nlog(max - min));
// * Space: O(1);

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        
        if (matrix[0] == null || matrix[0].length == 0) {
            return -1;
        }
        
        int n = matrix.length - 1;
        int minVal = matrix[0][0];
        int maxVal = matrix[n][n];
        while (minVal <= maxVal) {
            int midVal = minVal + (maxVal - minVal) / 2;
            int count = numOfSmaller(matrix, midVal);
            if (count >= k) {
                maxVal = midVal - 1;
            } else {
                minVal = midVal + 1;
            }
        }
        return minVal;
    }
    
    
    private int numOfSmaller(int[][] matrix, int target) {
        int num = 0;
        int n = matrix.length;
        for (int[] arr : matrix) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            num += left;
        }
        return num;
    }
}







