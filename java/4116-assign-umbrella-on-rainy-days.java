class Solution {
    public String[] assignUmbrella(int[] rain) {
        int aliceCount = 0;
        int bobCount = 0;
        int n = rain.length;
        String[] answer = new String[n];
        for (int i = 0; i < n; ++i) {
            if (rain[i] == 0) {
                answer[i] = "None";
                continue;
            }
            if (i < n - 1 && rain[i] == rain[i + 1] && aliceCount <= bobCount) {
                answer[i] = "Alice";
                ++aliceCount;
            }
            else {
                answer[i] = "Bob";
                ++bobCount;
            }
        }
        return answer;
    }
}