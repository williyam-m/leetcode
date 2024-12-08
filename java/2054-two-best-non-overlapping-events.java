class Event {
    int time;
    int value;
    boolean isStart;
    Event(int time, int value, boolean isStart) {
        this.time = time;
        this.value = value;
        this.isStart = isStart;
    }
}
class Solution {
    public int maxTwoEvents(int[][] events) {
        int ans = 0;
        int maxValue = 0;
        Event[] evts = new Event[events.length * 2];
        for (int i = 0; i < events.length; ++i) {
            int start = events[i][0];
            int end = events[i][1];
            int value = events[i][2];
            evts[i * 2] = new Event(start, value, true);
            evts[i * 2 + 1] = new Event(end + 1, value, false);
        }
        Arrays.sort(evts, (a, b) -> a.time == b.time ? Integer.compare(a.isStart == true ? 1 : 0, b.isStart == true ? 1 : 0) : Integer.compare(a.time, b.time));

        for (Event evt : evts) {
            if (evt.isStart)
               ans = Math.max(ans, evt.value + maxValue);
            else
               maxValue = Math.max(maxValue, evt.value);
        }

        return ans;
    }
}