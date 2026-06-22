class Solution {
    /**
     * @param {number[]} nums
     * @return {number[]}
     */
    productExceptSelf(nums) {
        const n = nums.length;
        const prefix = new Array(n).fill(1);
        const suffix = new Array(n).fill(1);
        const product = new Array(n);

        for (let i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1]
        }

        for (let j = n - 2; j >= 0; j--) {
            suffix[j] = nums[j + 1] * suffix[j + 1]
        }

        for (let i = 0; i < n; i++) {
            product[i] = prefix[i] * suffix[i]
        }
        return product;
    }
}
