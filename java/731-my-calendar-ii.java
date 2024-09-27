class MyCalendarTwo {
    private List<int[]> booking;
    private List<int[]> doubleBooking;
    public MyCalendarTwo() {
        booking = new ArrayList<>();
        doubleBooking = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] b : doubleBooking) {
            if (Math.max(b[0], start) < Math.min(b[1], end)) {
                return false;
            }
        }
        for (int[] b : booking) {
            if (Math.max(b[0], start) < Math.min(b[1], end)) {
                doubleBooking.add(new int[] {Math.max(b[0], start), Math.min(b[1], end)});
            }
        }
        booking.add(new int[] {start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */