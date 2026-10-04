class Solution {
    public int minRotations(String s) {
        int ans = 0;
        int pointer = 0;
        for (char c : s.toCharArray()) {
            int curr = c - '0';
            if (pointer < curr) {
                ans += Math.min(curr - pointer, (pointer - 0) + (9 - curr) + 1);
            }
            else if (pointer > curr) {
                ans += Math.min(pointer - curr, (curr - 0) + (9 - pointer) + 1);
            }
            // no operation if pointer == curr
            pointer = curr;
        }
        return ans;
    }
}