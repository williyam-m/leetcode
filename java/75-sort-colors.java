class Solution {
    public void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 1) {
                ++mid;
            }
            else if (nums[mid] == 2) {
                nums[mid] = nums[right];
                nums[right--] = 2;
            }
            else {
                nums[mid++] = nums[left];
                nums[left++] = 0;
            }
        }
    }
}