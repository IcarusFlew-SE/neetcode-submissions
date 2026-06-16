class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(); // HashMap to store anagrams

        //Iterate each string in array
        for (int i = 0; i < strs.length; i++){
            char[] sortChar = strs[i].toCharArray();
            Arrays.sort(sortChar);
            String str = new String(sortChar);

            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>()); // If sorted string not found in map, add to new List
            }
            map.get(str).add(strs[i]); //add original string corresponding to the sorted string (by-key)

        } return new ArrayList<>(map.values()); // return the List storing the sorted values
    } 
}
