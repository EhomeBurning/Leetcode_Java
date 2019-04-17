// * Tag: Binary Search -> others;
// * Solution: either start with top right or bottom left; x++, y-- to locate target;
// * Time: O(m + n);
// * Space: O(1);

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0, y = matrix[0].length - 1;
        while (x <= row - 1 && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
