class TrieNode {
    TrieNode[] node = new TrieNode[26];
    int count = 0;
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode dummy = root;
            for (int i = 0; i < word.length(); ++i) {
                int child = word.charAt(i) - 'a';
                if (dummy.node[child] == null) {
                    dummy.node[child] = new TrieNode();
                }
                dummy = dummy.node[child]; 
                dummy.count += 1;
            }
        }

        int[] answer = new int[words.length];

        for (int i = 0; i < words.length; ++i) {
            TrieNode dummy = root;
            int ans = 0;
            for (int j = 0; j < words[i].length(); ++j) {
                dummy = dummy.node[words[i].charAt(j) - 'a']; 
                ans += dummy.count;
            }
            answer[i] = ans;
        }

        return answer;


        /*  TLE
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            for (int i = 1; i <= word.length(); ++i)
                map.merge(word.substring(0, i), 1, Integer::sum);
        }

        int n = words.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 1; j <= words[i].length(); ++j)
                count += map.get(words[i].substring(0, j));
            answer[i] = count;
        }
        return answer;
        */
    }
}