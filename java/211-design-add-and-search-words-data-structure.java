class TrieNode {
    TrieNode[] trie = new TrieNode[26];
    boolean isWord = false;
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.trie[c - 'a'] == null)
               node.trie[c - 'a'] = new TrieNode();
            node = node.trie[c - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs (String word, int i, TrieNode node) {
        if (node == null)
            return false;
        if (i == word.length())
            return node.isWord;

        if (word.charAt(i) != '.')
            return dfs(word, i + 1, node.trie[word.charAt(i) - 'a']);

        for (int j = 0; j < 26; ++j) {
            if (dfs(word, i + 1, node.trie[j]))
                return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */