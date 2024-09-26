class MyCalendar {
    private List<int[]> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] l : list) {
            if ((l[0] <= start && l[1] > start) || (l[0] < end && l[1] >= end) || (l[0] >= start && l[0] < end) || (l[1] > start && l[1] < end))
                return false;
        }
        list.add(new int[] {start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */