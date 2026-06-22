class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Iterate through the array and skip the current index of the element, not inserted into the product operaton
        int n = nums.length;
        int[] prefix = new int[n]; // stores all elements before ith index
        int[] suffix = new int[n];  // stores after
        int[] product = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        suffix[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            suffix[j] = nums[j + 1] * suffix[j + 1];
        }

        for (int i = 0; i < n; i++) {
            product[i] = prefix[i] * suffix[i];
        }
        return product;
    }
}  
