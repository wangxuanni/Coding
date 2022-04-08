package leetcode.tree;

/**
 *
 * 前缀树
 * @author keyu
 * @since 2022-04-08 10:43
 **/

class Trie {
    TrieNode trie;

    static class TrieNode {
        boolean isEnd;
        TrieNode[] trieArr = new TrieNode[26];
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        trie = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = trie;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int charNum = aChar - 'a';
            if (cur.trieArr[charNum] == null) {
                cur.trieArr[charNum] = new TrieNode();
            }
            cur = cur.trieArr[charNum];
        }
        cur.isEnd = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = trie;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int charNum = aChar - 'a';
            if (cur.trieArr[charNum] == null)
                return false;
            cur = cur.trieArr[charNum];
        }
        return cur.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode cur = trie;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int charNum = aChar - 'a';
            if (cur.trieArr[charNum] == null)
                return false;
            cur = cur.trieArr[charNum];
        }
        return true;
    }
}
