import java.util.*;



public class FindAncestorAtDistance {
    public static int[] solution(int D, int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        if (D == 0) {
            return A;
        }
        int[] result = new int[A.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = dfs(A, i, D);
        }
        return result;
    }

    private static int dfs(int[] A, int rootNode, int distance) {
        if (rootNode == -1 || distance == 0) {
            return rootNode;
        } else {
            rootNode = A[rootNode];
            distance -= 1;
            return dfs(A, rootNode, distance);
        }
    }

    public static void main(String args[]) {
//        int[] A = {-1, 0, 1, 2, 3};
//        int D = 2;
        int[] A = {-1, 0, 4, 2, 1};
        int D = 0;
        System.out.println(Arrays.toString(solution(D, A)));
    }
}
