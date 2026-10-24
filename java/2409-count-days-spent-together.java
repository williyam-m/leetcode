class Solution {
    private static final int[] cumulativeDaysByMonth;
    static {
        cumulativeDaysByMonth = new int[12];
        int[] daysInEachMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < 12; ++i) {
            cumulativeDaysByMonth[i] = cumulativeDaysByMonth[i - 1] + daysInEachMonth[i - 1];
        }
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveAliceInDays = cumulativeDaysByMonth[Integer.parseInt(arriveAlice.substring(0, 2)) - 1] + Integer.parseInt(arriveAlice.substring(3, 5));
        int leaveAliceInDays = cumulativeDaysByMonth[Integer.parseInt(leaveAlice.substring(0, 2)) - 1] + Integer.parseInt(leaveAlice.substring(3, 5));
        int arriveBobInDays = cumulativeDaysByMonth[Integer.parseInt(arriveBob.substring(0, 2)) - 1] + Integer.parseInt(arriveBob.substring(3, 5));
        int leaveBobInDays = cumulativeDaysByMonth[Integer.parseInt(leaveBob.substring(0, 2)) - 1] + Integer.parseInt(leaveBob.substring(3, 5));
        int daysTogether = Math.min(leaveAliceInDays, leaveBobInDays) - Math.max(arriveAliceInDays, arriveBobInDays) + 1;
        return daysTogether < 0 ? 0 : daysTogether;
    }
}