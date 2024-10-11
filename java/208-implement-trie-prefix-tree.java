class TrieNode {
    TrieNode[] trie = new TrieNode[26];
    boolean isWord = false;
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode dummy = root;
        for (char c : word.toCharArray()) {
            if (dummy.trie[c - 'a'] == null)
                dummy.trie[c - 'a'] = new TrieNode();
            dummy = dummy.trie[c - 'a'];
        }
        dummy.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode dummy = root;
        for (char c : word.toCharArray()) {
            if (dummy.trie[c - 'a'] == null)
                return false;
            dummy = dummy.trie[c - 'a'];
        }
        return dummy.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode dummy = root;
        for (char c : prefix.toCharArray()) {
            if (dummy.trie[c - 'a'] == null)
                return false;
            dummy = dummy.trie[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */