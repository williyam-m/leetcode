class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int minDistance = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < drones.length; ++i) {
            int currDistance = findManhattanDistance(drones[i], target);
            if (currDistance <= drones[i][2] && minDistance > currDistance) {
                minDistance = currDistance;
                index = i;
            }
        }
        return index;
    }
    private int findManhattanDistance(int[] drone, int[] target) {
        return Math.abs(drone[0] - target[0]) + Math.abs(drone[1] - target[1]);
    }
}