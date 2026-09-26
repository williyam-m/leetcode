class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> kv : knowledge) {
            map.put(kv.get(0), kv.get(1));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                StringBuilder key = new StringBuilder(s.charAt(++i));
                while (s.charAt(i) != ')') {
                    key.append(s.charAt(i++));
                }
                sb.append(map.containsKey(key.toString()) ? map.get(key.toString()) : "?");
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}