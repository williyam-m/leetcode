class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        int ele = 1;
        while (ans.size() < n) {
            ans.add(ele);
            if (ele * 10 <= n) {
                ele *= 10;
            } else {
                while (ele == n || ele % 10 == 9) {
                    ele /= 10;
                }
                ++ele;
            }
        }
        return ans;
    }
}