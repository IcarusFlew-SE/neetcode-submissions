class Solution {
    public boolean isAnagram(String s, String t) {
        //check for valid counts of char
        if (s.length() != t.length()) return false;
        // Map to map search for if map contains : HashMap for non-ordered 
        HashMap<Character, Integer> map = new HashMap<>();
        // Check for String s
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);   
            } else {
                map.put(s.charAt(i), 1); // first occurence of element
            }
        }
        // Check for String t
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        // Extract unique keys via Set
        Set<Character> keys = map.keySet();

        for (Character key : keys) {
            if (map.get(key) != 0){
            return false;
            }
        }
        return true;
    }
}