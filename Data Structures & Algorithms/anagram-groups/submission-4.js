class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {
        const res = {};
        let n = strs.length
        for (let i = 0; i < n; i++) {
            let word = strs[i]
            let sorted = word.split("").sort().join("")

            if(res[sorted] !== undefined)
            res[sorted].push(word);
            else
            res[sorted] = [word];
        }
        let finalRes = []
        for (const key in res) {
            finalRes.push(res[key])
        }
        return finalRes
    }
}
