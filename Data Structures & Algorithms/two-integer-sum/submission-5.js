class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        const numMap = new Map(); 

        for (let i = 0; i < nums.length; i++) { 
            const complement = target - nums[i];
            if (numMap.has(complement)) {
                return [i, numMap.get(complement)];
            }
            numMap.set(nums[i], i); 
        }
    }
}
