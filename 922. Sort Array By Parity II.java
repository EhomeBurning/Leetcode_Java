// * Tag: Two Pointers;
// > Assumptions:
// > 1. # even = # odd.
// > 2. array.length % 2 == 0.
// > Solution:
// > 1. i: even index; j: odd index;
// > 2. condition: i find odd num, j find even num, then swap;
// > Tips:
// > 1. in while loop, mind index exception every condition and put it in the first place.
// * Time: O(n);
// * Space: O(1);


class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        
        int i = 0, j = 1;
        int len = A.length;
        while (i < len && j < len) {
            // find odd num
            while (i < len && A[i] % 2 == 0) {
                i += 2;
            }
            // find even num
            while (j < len && A[j] % 2 == 1) {
                j += 2;
            }
            if (i < len && j < len) {
                swap(A, i, j);
            }
        }
        return A;
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
