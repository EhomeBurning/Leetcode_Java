public class Lc211_Add_And_Search_Words {
}
// time : O(n)  n: word.length();
// O(num of TrieNode * 26) = O(num of Words * word.length() * 26)

class TrieNode {

    TrieNode[] children;
    boolean isWord;
    String word;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
        word = "";
    }
}

public class AddandSearchWord {
    private TrieNode root;


    /** Initialize your data structure here. */
    public AddandSearchWord() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    // time : O(n)  n: word.length();
    // O(num of TrieNode * 26) = O(num of Words * word.length() * 26)
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.isWord = true;
        node.word = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, root, 0);
    }

    public boolean find(String word, TrieNode node, int index) {
        if (index == word.length()) return node.isWord;//!node.word.equals("");
        if (word.charAt(index) == '.') {
            for (TrieNode temp : node.children) {
                if (temp != null && find(word, temp, index + 1)) return true;
            }
            return false;
        } else {
            int j = word.charAt(index) - 'a';
            TrieNode temp = node.children[j];
            return temp != null && find(word, temp, index + 1);
        }
    }
}

