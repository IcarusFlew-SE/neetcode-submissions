class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isValid(s) {
        const stack = [];
        const frontEnd = {
            ')':'(',
            ']':'[',
            '}':'{',
        }

        for (let c of s) {
            if (frontEnd[c]) {
                if (stack.length > 0 && stack[stack.length - 1] === frontEnd[c]) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.length === 0;
    }
}
