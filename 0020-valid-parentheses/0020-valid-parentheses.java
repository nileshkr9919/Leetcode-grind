class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (Character ch : s.toCharArray()) {
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