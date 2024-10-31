class Solution {
    private long[][][] mem;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> (a[0] - b[0]));
        mem = new long[robot.size()][factory.length][robot.size()];
        return minimumTotalDistance(robot, factory, 0, 0, 0);
    }
    private long minimumTotalDistance(List<Integer> robot, int[][] factory, int i, int j, int k) {
        if (i >= robot.size())
           return 0;
        if (j >= factory.length)
           return Long.MAX_VALUE;
        if (mem[i][j][k] > 0)
           return mem[i][j][k]; 
        long skipFactory = minimumTotalDistance(robot, factory, i, j + 1, 0);
        long useFactory = factory[j][1] > k ? minimumTotalDistance(robot, factory, i + 1, j, k + 1)
                         + Math.abs(robot.get(i) - factory[j][0]) : Long.MAX_VALUE / 2;
        return mem[i][j][k] = Math.min(skipFactory, useFactory);
    }
}