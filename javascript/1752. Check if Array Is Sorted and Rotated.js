/**
 * @param {number[]} nums
 * @return {boolean}
 */
var check = function(nums) {
    var decrease = 0;
    var len = nums.length;
    if (nums[0] < nums[len - 1])
        ++decrease;
    
    for (var i = 0; i < len - 1; ++i) {
        if (nums[i] > nums[i + 1]) {
            if (++decrease == 2)
               return false;
        }
    }
    return true;
};