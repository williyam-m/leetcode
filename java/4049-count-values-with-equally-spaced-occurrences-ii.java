class CountValue {
    int count = 0;
    int lastIndex = -1;
    int distance = -1;
    boolean inValid = false;
    CountValue(int index) {
        lastIndex = index;
        count = 1;
    }
}
class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, CountValue> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new CountValue(i));
                continue;
            }
            CountValue cv = map.get(nums[i]);
            if (cv.inValid == true) {
                continue;
            }
            ++cv.count;

            if (cv.distance == -1) {
                cv.distance = i - cv.lastIndex;
                cv.lastIndex = i;
                continue;
            }
            else if (cv.distance != i - cv.lastIndex) {
                if (cv.count > 3) {
                    --ans;
                }
                cv.inValid = true;
                continue;
            }
            cv.lastIndex = i;
            if (cv.count == 3) {
                ++ans;
            }
        }
        return ans;
    }
}