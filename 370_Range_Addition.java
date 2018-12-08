public class Lc370_Range_Addition {

/**
 * 在303题的基础上变形，反正都是储存sum的值在新的list里
 * Time Complexity:
 * Space Complexity:
 */

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int value = update[2];
            res[start] += value;
            if (end + 1 < length) {
                res[end + 1] -= value;
            }
        }

        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }
}