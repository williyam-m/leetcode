class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Queue<int[]> maxHeap = new PriorityQueue<>((A, B) -> B[0] - A[0]);
        if (a > 0)
            maxHeap.offer(new int[] { a, 'a' });
        if (b > 0)
            maxHeap.offer(new int[] { b, 'b' });
        if (c > 0)
            maxHeap.offer(new int[] { c, 'c' });
        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == first[1]
                    && sb.charAt(sb.length() - 2) == first[1]) {

                if (maxHeap.isEmpty())
                    break;
                int[] second = maxHeap.poll();
                sb.append((char) second[1]);
                --second[0];
                if (second[0] > 0)
                    maxHeap.offer(second);
            } else {
                sb.append((char) first[1]);
                --first[0];
            }

            if (first[0] > 0)
                maxHeap.offer(first);
        }
        return sb.toString();
    }
}