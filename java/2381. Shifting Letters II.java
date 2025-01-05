class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder sb = new StringBuilder();
        int currShift = 0;
        int[] timeline = new int[s.length() + 1];
        for (int[] shift : shifts) {
            int diff = shift[2] == 1 ? 1 : -1;
            timeline[shift[0]] += diff;
            timeline[shift[1] + 1] -= diff;
        }

        for (int i = 0; i < s.length(); ++i) {
            currShift = (currShift + timeline[i]) % 26;
            int c = (s.charAt(i) - 'a' + currShift + 26) % 26;
            sb.append((char) (c + 'a'));
        }
        return sb.toString();
        /* TLE
        StringBuilder sb = new StringBuilder(s);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        for (int[] shift : shifts)
            pq.add(shift);

        for (int i = 0; i < sb.length(); ++i) {
            int totalShift = 0;
            while (!pq.isEmpty() && pq.peek()[0] == i) {
                int[] curr = pq.poll();
                if (curr[2] == 1)
                   ++totalShift;
                else
                   --totalShift;
                if (curr[0] + 1 > curr[1])
                   continue;
                pq.add(new int[] {curr[0] + 1, curr[1], curr[2]});
            }
            if (totalShift == 0)
               continue;
            int c = sb.charAt(i) - 'a';
            c = ((c + totalShift) % 26) + 'a';
            sb.setCharAt(i, (char) c);
        }
        return sb.toString();
        */
    }
}