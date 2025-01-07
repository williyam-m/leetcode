class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < words.length; j++) {
                String w = words[j];
                if (j != i && word.contains(w) && set.add(w))
                    list.add(w);
            }
        }
        return list;
    }
}