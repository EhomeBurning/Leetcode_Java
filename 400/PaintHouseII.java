package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PaintHouseII
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 265. Paint House II
 */
public class PaintHouseII {
    /**
     * There are a row of n houses, each house can be painted with one of the k colors.
     * The cost of painting each house with a certain color is different.
     * You have to paint all the houses such that no two adjacent houses have the same color.

     The cost of painting each house with a certain color is represented by a n x k cost matrix.
     For example, costs[0][0] is the cost of painting house 0 with color 0;
     costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

     Note:
     All costs are positive integers.


     time : O(n * k)
     space : O(1)


     * @param costs
     * @return
     */

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;

        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1; min2 = -1;
            for (int j = 0; j < k; j++) {
                if (j != last1) {
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }

                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        return costs[n - 1][min1];
    }
}
