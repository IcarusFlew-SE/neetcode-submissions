class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> frontEnd = new HashMap<>();
        frontEnd.put(')', '(');
        frontEnd.put(']', '[');
        frontEnd.put('}', '{');
        for (char c : s.toCharArray()) {
            if (frontEnd.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == frontEnd.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
