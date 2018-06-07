/**
 * Tag: Array
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


public class Lc243_Shortest_Word_Distance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int minDistance = words.length;
        int index1 = -1, index2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
            } else if (word2.equals(words[i])) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                minDistance = Math.min(minDistance,Math.abs(index1 - index2));
            }
        }
        return minDistance;
    }
}