import java.util.HashMap;

/**
 * Tag: Hash Table
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class Lc760_Find_Anagram_Mappings {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }

        int[] res = new int[B.length];
        for (int j = 0; j < A.length; j++) {
            res[j] = map.get(A[j]);
        }

        return res;
    }
}