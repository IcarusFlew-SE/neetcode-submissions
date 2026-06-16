class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); //HashMap (key-pair values) to store indices of numbers
        // Iterate array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // complement of current num

            if (seen.containsKey(complement)) { // Check validated complement existing in map -> seen
                return new int[] {seen.get(complement), i};
            }
            else {
                seen.put(nums[i], i);
            }
        } return new int[0];
    }
}
