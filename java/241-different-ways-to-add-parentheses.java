class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return ways(expression, new HashMap<>());
    }

    private List<Integer> ways(String s, Map<String, List<Integer>> mem) {
        if (mem.containsKey(s))
            return mem.get(s);

        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i))) {
                for (int a : ways(s.substring(0, i), mem)) {
                    for (int b : ways(s.substring(i + 1), mem)) {
                        if (s.charAt(i) == '+')
                            ans.add(a + b);
                        else if (s.charAt(i) == '-')
                            ans.add(a - b);
                        else
                            ans.add(a * b);
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            mem.put(s, Arrays.asList(Integer.parseInt(s)));
            return mem.get(s);
        }

        mem.put(s, ans);
        return ans;
    }
}