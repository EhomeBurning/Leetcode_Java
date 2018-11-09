/**
 * Tag: Binary Search, Array
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */


public class Lc74_Search_A_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0, end = row * col - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int num = matrix[mid / col][mid % col];

            if (num == target) {
                return true;
            } else if (num > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (matrix[start / col][start % col] == target) {
            return true;
        }else if (matrix[end / col][end % col] == target) {
            return true;
        }

        return false;

    }
}