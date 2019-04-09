// *Tag*: BFS; <br>
// *Solution*: <br>
// BFS: One Queue, one HashSet. Queue stores one level of words. Each level is oneEditDistance away. HashSet stores all the words that has been visited. (1) queue is not empty. (2) every word in queue. (3) all oneEditDistance words of the beginning word. <br>
// oneEditDistance: Generate rule for the word in queue to expand the next level. for 26 letters in English, change one letter of the words. If the changed word exists in the wordList, then it is oneEditDistance. <br>
// *Time*: O(n + m); <br>
// *Space*: O(n); <br>
// *Tips*: <br>
// 1. Compare two ways of oneEditDistance: <br>
// (1) Compare all the words in wordList to the begin word. wordList -> N, word length -> L. Time: O(N * L) <br>
// (2) oneEditDistance: wordList -> N, word length -> L. Time: O(26 * L^2);



class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = 1;
        HashSet<String> wordSet = new HashSet<String>(wordList);
        
        if (beginWord.equals(endWord)) {
            return length;
        }
        
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        queue.offer(beginWord);
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : oneEditDistance(word, wordSet)) {
                    if (nextWord.equals(endWord)) {
                        return length;
                    }
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    queue.offer(nextWord);
                    visited.add(nextWord);
                }
            }
        }
        return 0;
    }
    
    // Search all oneEditDistance words in the list;
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'};
    // it will return ['hit', 'hog'];
    private ArrayList<String> oneEditDistance(String word, HashSet<String> wordSet) {
        ArrayList<String> result = new ArrayList<String>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < word.length(); i++) {
                if (ch == word.charAt(i)) {
                    continue;
                }
                // replace word one char
                char[] chars = word.toCharArray();
                chars[i] = ch;
                String newWord = new String(chars);
                
                if (wordSet.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }
        return result;
    }
}





























