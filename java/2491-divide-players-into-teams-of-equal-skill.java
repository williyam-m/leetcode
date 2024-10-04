class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int l = 0;
        int r = skill.length - 1;
        long skillSum = skill[l] + skill[r];
        long currSum = 0;
        long chemistry = 0;
        while (l < r) {
            currSum = skill[l] + skill[r];
            if (currSum != skillSum)
                return -1;
            chemistry += skill[l++] * skill[r--];
        }
        return chemistry;
    }
}