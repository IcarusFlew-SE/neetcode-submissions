class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
        if (s.length !== t.length) {
            return false;
        }
        // Create Map
        let map = new Map();
        // Populate first map with s string
        for (let i = 0; i < s.length; i++) {
            map.set(s[i], (map.get(s[i]) || 0) + 1); // getOrDefault
        }

        for (let i = 0; i < t.length; i++) {
            if (!map.has(t[i])) return false;
            map.set(t[i], (map.get(t[i]) || 0) - 1);
        }

        for (let val of map.values()) {
            if (val !== 0) return false;
        }
        return true;
    }
}
