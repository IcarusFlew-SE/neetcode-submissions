class Solution {
    public int trap(int[] height) {
        // read through the array from left to right (each number : cols)
        // Two pointers approach
        int left = 1;
        int right = height.length - 2;

        int prefix = height[left - 1];
        int suffix = height[right + 1];

        int rain = 0;
        while (left <= right) {
            if (suffix <= prefix) {
                rain += Math.max(0, suffix - height[right]); // Add water
                suffix = Math.max(suffix, height[right]); // update right-suffix
                right -= 1; 
            }
            else {
                rain += Math.max(0, prefix - height[left]);
                prefix = Math.max(prefix, height[left]);
                left += 1;
            }
        }
        return rain;
    }
}
