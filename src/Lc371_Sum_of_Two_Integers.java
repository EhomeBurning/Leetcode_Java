/**
 * Tag: Bit Manipulation
 * Time Complexity: O(1) or O(n)
 * Space Complexity: O(1)
 * */
public class Lc371_Sum_of_Two_Integers {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}