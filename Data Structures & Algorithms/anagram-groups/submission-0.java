class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(); // HashMap to store anagrams

        //Iterate each string in array
        for (String s : strs) {
            // Convert string to char array and sort 
            char[] charArr = s.toCharArray(); 
            Arrays.sort(charArr);
            // Convert sorted char back to string
            String sortedString = new String(charArr);

            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>()); // If sorted string not found in map, add to new List
            }
            map.get(sortedString).add(s); //add original string corresponding to the sorted string (by-key)

        } return new ArrayList<>(map.values()); // return the List storing the sorted values
    } 
}
