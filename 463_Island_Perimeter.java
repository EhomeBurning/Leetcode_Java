// Solution: loop through all the points of the matrix. For each point which equals 1, see it is surrounded by how many 0. Each zero increases perimeter by 1.
// Tips: 1. Each surrounded zero should be in the matrix range.
//       2. For those not in the range, still add perimeter one.

// time: O(n)
// space: O(1)

class Solution {
    int[] xList = {0, -1, 0, 1};
    int[] yList = {-1, 0, 1, 0};
    
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        if (isZero(i + xList[k], j + yList[k], grid)) {
                            perimeter++;
                        }
                    }
                }
            }
        }
        return perimeter;
    }
    
    private boolean isZero(int x, int y, int[][] grid) {
        if (0 <= x && x < grid.length && 0 <= y && y < grid[x].length) {
            return grid[x][y] == 0;
        }
        return true;
    }
}
