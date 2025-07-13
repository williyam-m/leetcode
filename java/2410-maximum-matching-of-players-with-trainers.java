class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Integer[] playersSorted = Arrays.stream(players).boxed().toArray(Integer[]::new);
        Integer[] trainersSorted = Arrays.stream(trainers).boxed().toArray(Integer[]::new);
        Arrays.sort(playersSorted, Collections.reverseOrder());
        Arrays.sort(trainersSorted, Collections.reverseOrder());

        int ans = 0;
        int p2 = 0;

        for (int p1 = 0; p1 < trainersSorted.length && p2 < playersSorted.length; ++p2) {
            if (trainersSorted[p1] >= playersSorted[p2]) {
                ++ans;
                ++p1;
            }
        }
        return ans;
    }
}