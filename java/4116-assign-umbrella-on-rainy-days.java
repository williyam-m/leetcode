class Solution {
    public String[] assignUmbrella(int[] rain) {
        final String NONE = "None";
        final String ALICE = "Alice";
        final String BOB = "Bob";
        int aliceCount = 0;
        int bobCount = 0;
        int n = rain.length;
        String[] answer = new String[n];
        for (int i = 0; i < n; ++i) {
            if (rain[i] == 0) {
                answer[i] = NONE;
                continue;
            }
            if (i < n - 1 && rain[i] == rain[i + 1] && aliceCount <= bobCount) {
                answer[i] = ALICE;
                ++aliceCount;
            }
            else {
                answer[i] = BOB;
                ++bobCount;
            }
        }
        return answer;
    }
}