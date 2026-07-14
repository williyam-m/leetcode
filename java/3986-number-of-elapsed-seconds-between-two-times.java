class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return toSeconds(endTime.split(":")) - toSeconds(startTime.split(":"));
    }
    private int toSeconds(String[] str) {
        return (Integer.parseInt(str[0]) * 60 * 60) + 
                (Integer.parseInt(str[1]) * 60) + 
                Integer.parseInt(str[2]);
    }
}