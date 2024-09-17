class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String s : arr1)
            map.merge(s, 1, Integer::sum);
        for (String s : arr2)
            map.merge(s, 1, Integer::sum);
        for (String s : map.keySet()) {
            if (map.get(s) == 1)
               list.add(s);
        }
        return list.toArray(new String[0]);
            
    }
}