class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        const numMap = {} // declare variable - const

        for (let i = 0; i < nums.length; i++) { // declare data-type based variable - let
            const complement = target - nums[i];
            if (numMap.hasOwnProperty(complement)){ // object variable - []
                return [numMap[complement], i]
            }
            numMap[nums[i]] = i;
        }
    }
}
