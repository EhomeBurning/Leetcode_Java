/**
 * Tag: Bit Manipulation
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class Lc191_Num_of_1_Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
}