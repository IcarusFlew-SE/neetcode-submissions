class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                int current = num;
                while (numSet.contains(current + 1)) {
                    length++;
                    current++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
