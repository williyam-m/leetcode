class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int UpDown = 0;
        int RightLeft = 0;

        for (String command : commands) {
            if (command.equals("UP"))
                --UpDown;
            else if (command.equals("DOWN"))
                ++UpDown;
            else if (command.equals("RIGHT"))
                ++RightLeft;
            else
                --RightLeft;
        }
        return (UpDown * n) + RightLeft;
    }
}