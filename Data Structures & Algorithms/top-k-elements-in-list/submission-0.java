class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        // Bucket Sort
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int i = 0; i <= nums.length; i++){
            bucket[i] = new ArrayList<>();
        }

        for (int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num,0) + 1);
            bucket[frequencyMap.get(num)].add(num);
        }

        for (int i = nums.length; i >= 0; i--){
            if (bucket[i].size() == k){
                for (int j = 0; j < k; j++){
                    result[j] = bucket[i].get(j);
                }
                break;
            }
        } return result;
    }
}
