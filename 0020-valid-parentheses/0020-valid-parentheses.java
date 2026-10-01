class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> st = new Stack<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                st.push(ch);
            } else {
                if (st.isEmpty() || st.peek() != map.get(ch)) {
                    return false;
                }
                st.pop();
            }
        }

        return st.isEmpty();

    }
}