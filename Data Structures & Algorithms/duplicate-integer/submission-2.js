class Solution {
    /**
     * @param {number[]} nums
     * @return {boolean}
     */
    hasDuplicate(nums) {
        let object = {}
        for (let i = 0; i < nums.length; i++) {
            if (object[nums[i]]){
                return true;
            } else {
                object[nums[i]] = true;
            }
        }
        return false;
    }
}
